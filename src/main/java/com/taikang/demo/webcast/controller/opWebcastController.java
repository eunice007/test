package com.taikang.demo.webcast.controller;

import com.taikang.demo.core.common.constant.RedPointEnum;
import com.taikang.demo.core.common.constant.RedisKeyEnum;
import com.taikang.demo.core.common.dto.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Eunice
 * @date 2018/9/15
 */
@RestController
@RequestMapping("/opWebcast/")
@Slf4j
public class opWebcastController {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 判断是否显示小红点
     * @param managerNo
     * @return
     */
    @ApiOperation(value = "小红点, 根据代理人编号查询是否显示小红点 0显示 其他情况不显示")
    @GetMapping("redPoint")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "managerNo", required = true, value = "代理人工号")
    })
    public BaseResponse redPointForAgent(@RequestParam(required = true) String managerNo){

        String key = String.format(RedisKeyEnum.观影券小红点.getRedisKeyFormat(), managerNo);
        log.info("redisKey---"+key);
        Object obj = redisTemplate.opsForValue().get(key);
        if (null != obj && Objects.equals(obj, RedPointEnum.显示.getCode())){
            return new BaseResponse(0, "显示");
        }
        return new BaseResponse(-3, "不显示");
    }
}
