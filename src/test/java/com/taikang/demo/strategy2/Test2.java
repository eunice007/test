package com.taikang.demo.strategy2;

/**
 * 利用宿主类, 将具体策略类定义为宿主类的静态成员类, 并将其实例定义为宿主类的公有静态属性
 * 适用于具体策略被多次调用的情况
 *
 * @author Eunice
 * @date 2018/9/4
 */
public class Test2 {
    public static void main(String[] args) {

        //通过宿主类获取具体策略
        Compare stringLengthCompare = Host.STRING_LENGTH_COMPARE;
        Compare integerCompare = Host.INTEGER_COMPARE;

        System.out.println(stringLengthCompare.compare("love god", "love"));
        System.out.println(integerCompare.compare(12, 13));
    }
}
