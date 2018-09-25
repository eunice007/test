package com.taikang.demo.strategy2;

/**
 * @author Eunice
 * @date 2018/9/4
 */
public class Test3 {
    public static void main(String[] args) {
        Compare comp = Host2.getCompare(ConcreteStrategy.IntegerCompare);
        System.out.println(comp.compare(123, 124));
    }
}
