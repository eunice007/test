package com.taikang.demo.webcast.controller;

import com.taikang.demo.core.common.dto.BaseResponse;
import com.taikang.demo.webcast.dto.request.WebcastCouponReq;
import com.taikang.demo.webcast.service.TliveWebcastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 泰生活端 直播接口
 *
 * @author Eunice
 * @date 2018/9/17
 */
@RestController
@RequestMapping("/tliveWebcast/")
@Api(tags = "直播相关接口---泰生活端")
public class TliveWebcastController {
    @Resource
    private TliveWebcastService tliveWebcastService;

    @PostMapping(value = "getWebcastCoupon")
    @ApiOperation(value = "用户索取直播券", notes = "用户索取直播券")
    public BaseResponse getWebcastCoupon(@RequestBody WebcastCouponReq webcastCouponReq){

        return tliveWebcastService.getWebcastCoupon(webcastCouponReq);
    }
}
