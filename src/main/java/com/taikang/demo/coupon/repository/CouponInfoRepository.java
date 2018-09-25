package com.taikang.demo.coupon.repository;

import com.taikang.demo.coupon.repository.entity.CouponInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


/**
 * @author Eunice
 * @date 2018/8/9
 */
public interface CouponInfoRepository extends JpaRepository<CouponInfoEntity, Integer>,JpaSpecificationExecutor<CouponInfoEntity> {
    @Override
    List<CouponInfoEntity> findAll();
}
