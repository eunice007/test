package com.taikang.demo.strategy2;

/**
 * 策略接口
 *
 * @author Eunice
 * @date 2018/9/4
 */
public interface Compare<T> {
    public int compare(T p1, T p2);
}
