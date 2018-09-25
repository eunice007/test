package com.taikang.demo.strategy;

/**
 * 辅助类
 *
 * @author Eunice
 * @date 2018/9/4
 */
public abstract class AbstractOperator{

    public int[] split(String exp, String opt){
        String[] split = exp.split(opt);
        int[] ints = new int[2];
        ints[0] = Integer.parseInt(split[0]);
        ints[1] = Integer.parseInt(split[1]);
        return ints;
    }
}
