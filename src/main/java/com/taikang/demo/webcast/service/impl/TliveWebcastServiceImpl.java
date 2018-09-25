package com.taikang.demo.webcast.service.impl;

import com.google.common.collect.Maps;
import com.taikang.demo.core.common.constant.RedPointEnum;
import com.taikang.demo.core.common.constant.RedisKeyEnum;
import com.taikang.demo.core.common.constant.RedisTopicEnum;
import com.taikang.demo.core.common.dto.BaseResponse;
import com.taikang.demo.core.config.redis.redisListener.RedisListenerForRedPoint;
import com.taikang.demo.webcast.dto.common.WebcastCardGrantTypeEnum;
import com.taikang.demo.webcast.dto.common.WebcastCardStatusEnum;
import com.taikang.demo.webcast.dto.request.WebcastCouponReq;
import com.taikang.demo.webcast.repository.OpWebcastRecordRepository;
import com.taikang.demo.webcast.repository.entity.OpWebcastRecordEntity;
import com.taikang.demo.webcast.service.TliveWebcastService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * @author Eunice
 * @date 2018/9/17
 */
@Service(value = "tliveWebcastService")
public class TliveWebcastServiceImpl implements TliveWebcastService {
    @Resource
    private OpWebcastRecordRepository opWebcastRecordRepository;

    @Resource(name = "redisTemple")
    private RedisTemplate redisTemplate;

    /**
     * 泰生活用户索取直播券
     *
     * 给直播表上乐观锁解决高并发下库存扣减为负数的问题
     * 测试synchronized能否解决高并发
     *
     * @param webcastCouponReq
     * @return
     */
    @Override
    @Transactional
    public synchronized BaseResponse getWebcastCoupon(WebcastCouponReq webcastCouponReq) {
        BaseResponse baseResponse = new BaseResponse<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //1.op_webcast_record表中新增一条记录
        //1.1判断是否有场次直播
        //1.2判断用户是否已经有该场次的券
        //1.3判断该场直播的库存
        //1.4新增记录
        OpWebcastRecordEntity opWebcastRecordEntity = new OpWebcastRecordEntity();
        BeanUtils.copyProperties(webcastCouponReq, opWebcastRecordEntity);
        opWebcastRecordEntity.setWebcastCardNo(getWebcastCardNo());
        opWebcastRecordEntity.setStatus(WebcastCardStatusEnum.派券中.getCode());
        opWebcastRecordEntity.setCreateTime(timestamp);
        opWebcastRecordEntity.setGrantType(WebcastCardGrantTypeEnum.用户索券.getCode());
        OpWebcastRecordEntity save = opWebcastRecordRepository.save(opWebcastRecordEntity);
        //1.5添加2小时延时发券任务

        //1.5减库存

        if(save != null){
            //2.显示直播券小红点
            redisTemplate.opsForValue().set(String.format(RedisKeyEnum.观影券小红点.getRedisKeyFormat(), webcastCouponReq.getManagerId()), RedPointEnum.显示);

            //3.往泰行销端推送消息

            //4.往H5推送消息, 通知H5刷新页面
            HashMap<String, String> map = Maps.newHashMapWithExpectedSize(2);
            map.put("managerNo", webcastCouponReq.getManagerId().toString());
            map.put("message", "H5刷新页面");
            redisTemplate.convertAndSend(RedisTopicEnum.小红点.getTopic(), map);

            baseResponse.setCode(0);
            baseResponse.setMsg("success");
            baseResponse.setData(save);
        }else{
            baseResponse.setCode(-3);
            baseResponse.setMsg("索券失败");
            return baseResponse;
        }

        return baseResponse;
    }

    //获取直播券券码, UUID随机截取10位,并转成大写
    private String getWebcastCardNo(){
        String webcastCardNo = null;
        while (true){
            String string = UUID.randomUUID().toString();
            String s = string.replace("-", "");
            int length = s.length();
            Random random = new Random(47);
            int i = random.nextInt(length - 11);
            String substring = s.substring(i, i + 10);
            OpWebcastRecordEntity opWebcastRecordEntity = opWebcastRecordRepository.findByWebcastCardNo(substring);
            if (opWebcastRecordEntity == null){
                webcastCardNo = substring.toUpperCase();
                break;
            }
        }
        return webcastCardNo;
    }
}
