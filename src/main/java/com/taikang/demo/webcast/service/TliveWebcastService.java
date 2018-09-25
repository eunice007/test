package com.taikang.demo.webcast.service;

import com.taikang.demo.core.common.dto.BaseResponse;
import com.taikang.demo.webcast.dto.request.WebcastCouponReq;

/**
 * @author Eunice
 * @date 2018/9/17
 */
public interface TliveWebcastService {
    BaseResponse getWebcastCoupon(WebcastCouponReq webcastCouponReq);
}
