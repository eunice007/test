package com.taikang.demo.strategy;

/**
 * 具体策略类 Plus
 *
 * @author Eunice
 * @date 2018/9/4
 */
public class Plus extends AbstractOperator implements Operator {
    @Override
    public int operator(String exp) {
        int[] split = split(exp, "\\+");
        return split[0]+split[1];
    }
}
