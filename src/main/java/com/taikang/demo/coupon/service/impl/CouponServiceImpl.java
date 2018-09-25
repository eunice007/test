package com.taikang.demo.coupon.service.impl;

import com.taikang.demo.coupon.repository.CouponInfoRepository;
import com.taikang.demo.coupon.repository.entity.CouponInfoEntity;
import com.taikang.demo.coupon.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Service("couponService")
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponInfoRepository couponInfoRepository;

    /**
     * 获取优惠券信息集合
     * @return
     */
    @Override
    public List<CouponInfoEntity> getCouponInfoList() {
        return couponInfoRepository.findAll();
    }
}
