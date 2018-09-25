package com.taikang.demo.coupon.service;

import com.taikang.demo.coupon.repository.entity.CouponInfoEntity;

import java.util.List;

/**
 * @author Eunice
 * @date 2018/8/9
 */
public interface CouponService {
    /**
     * 获取优惠券信息集合
     * @return
     */
    List<CouponInfoEntity> getCouponInfoList();
}
