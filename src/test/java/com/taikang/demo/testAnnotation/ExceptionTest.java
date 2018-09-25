package com.taikang.demo.testAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExceptionTest注解, 抛出指定异常时运行
 *
 * @author Eunice
 * @date 2018/9/6
 */
@Retention(RetentionPolicy.RUNTIME) //运行时保留
@Target(ElementType.METHOD) //作用在方法上
public @interface ExceptionTest {
    Class<? extends Exception> value();
}
