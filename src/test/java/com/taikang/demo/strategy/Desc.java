package com.taikang.demo.strategy;

/**
 * 具体策略类 Desc
 *
 * @author Eunice
 * @date 2018/9/4
 */
public class Desc extends AbstractOperator implements Operator{
    @Override
    public int operator(String exp) {
        int[] split = split(exp, "\\-");
        return split[0]=split[1];
    }
}
