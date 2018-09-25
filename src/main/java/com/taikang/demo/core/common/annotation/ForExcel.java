package com.taikang.demo.core.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Eunice
 * @date 2018/8/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface ForExcel {
    /**
     * 在Excel表格中的顺序
     * @return
     */
    int order();

    /**
     * Excel的标题
     * @return
     */
    String title() default "";

    /**
     * 字段校验
     * @return
     */
    String validate() default "";
}
