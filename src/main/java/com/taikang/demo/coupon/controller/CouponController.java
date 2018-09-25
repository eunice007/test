package com.taikang.demo.coupon.controller;

import com.taikang.demo.core.common.dto.BaseResponse;
import com.taikang.demo.coupon.repository.entity.CouponInfoEntity;
import com.taikang.demo.coupon.service.CouponService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@RestController
@RequestMapping("/coupon/")
public class CouponController {
    @Resource
    private CouponService couponService;

    /**
     * 获取优惠券信息集合
     * @return
     */
    @GetMapping(value = "getCouponInfoList")
    @ApiOperation(value = "获取所有优惠券信息", notes = "获取所有优惠券信息集合")
    public BaseResponse getCouponInfoList(){
        List<CouponInfoEntity> couponInfoEntityList = couponService.getCouponInfoList();
        return new BaseResponse(0,"SUCCESS",couponInfoEntityList);
    }

    /**
     * 发券
     * @return
     */
    @PostMapping(value = "insertCoupon")
    @ApiOperation(value = "机构发券/自主发券", notes = "")
    public BaseResponse insertCoupon(){
        try {
            return new BaseResponse(0,"SUCCESS");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new BaseResponse(-4,"FAIL");
    }

    /**
     * 判断图片的分辨率
     * @param multipartFile
     * @return
     */
    @PostMapping(value = "uploadImg", produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseResponse uploadImg(MultipartFile multipartFile){
        BaseResponse baseResponse = null;

        return baseResponse;

    }

   /* public BaseResponse pvuv(HttpServletRequest request){
        request.get

    }
*/

}
