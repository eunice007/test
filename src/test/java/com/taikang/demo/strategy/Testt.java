package com.taikang.demo.strategy;

/**
 * @author Eunice
 * @date 2018/9/4
 */
public class Testt {
    public static void main(String[] args) {
        String exp = "1+1";
        Operator operator = new Plus();     //用户决定使用哪个具体策略
        int result = operator.operator(exp);

        System.out.println(result);
    }
}
