package com.taikang.demo.webcast.repository;

import com.taikang.demo.webcast.repository.entity.OpWebcastRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Eunice
 * @date 2018/9/17
 */
public interface OpWebcastRecordRepository extends JpaRepository<OpWebcastRecordEntity, Integer>, JpaSpecificationExecutor {

    OpWebcastRecordEntity findByWebcastCardNo(String substring);
}
