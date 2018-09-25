package com.taikang.demo.core.config.readWriteSeparationConfig.aspect;

import com.taikang.demo.core.common.constant.DataSourceType;
import com.taikang.demo.core.config.readWriteSeparationConfig.dynamicDataSourceConfig.DynamicDataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eunice
 * @date 2018/8/9
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    /**
     * 读切面
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.taikang.demo.*.service.impl.*.select*(..)) || execution(* com.taikang.demo.*.service.impl.*.find*(..)) " +
            "|| execution(* com.taikang.demo.*.service.impl.*.get*(..)) || execution(* com.taikang.demo.*.service.impl.*.query*(..))")
    public Object setReadDataSourceType(ProceedingJoinPoint point) throws Throwable {
        //方法要符合规则,并且没有开启事务,才使用读库作为数据源
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class declaringType = signature.getDeclaringType();
        boolean annotationPresent = declaringType.isAnnotationPresent(Transactional.class);
        if (!annotationPresent){
            DynamicDataSourceHolder.setDataSource(DataSourceType.read.getType());
        }
        if (log.isDebugEnabled()){
            log.info("数据切面: {}", "read");
        }
        return point.proceed();
    }

    /**
     * 写切面
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.taikang.demo.*.service.impl.*.delete*(..)) || execution(* com.taikang.demo.*.service.impl.*.update*(..)) " +
            "|| execution(* com.taikang.demo.*.service.impl.*.insert*(..))")
    public Object setWriteDataSourceType(ProceedingJoinPoint point) throws Throwable {
        DynamicDataSourceHolder.setDataSource(DataSourceType.write.getType());
        if (log.isDebugEnabled()){
            log.info("数据源切面: {}", "write");
        }
        return point.proceed();
    }

}
