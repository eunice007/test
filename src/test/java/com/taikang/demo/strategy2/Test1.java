package com.taikang.demo.strategy2;

/**
 * 用匿名类 声明 具体策略
 * 适用于只适用一次的具体策略
 * 缺点: 每次使用的时候都创建一个新的实例
 *
 * @author Eunice
 * @date 2018/9/4
 */
public class Test1 {
    public static void main(String[] args) {

        //用匿名类声明具体策略
        Compare comp = new Compare<String>() {

            //比较字符串长度的大小
            @Override
            public int compare(String p1, String p2) {
                return p1.length()-p2.length();
            }
        };

        System.out.println(comp.compare("love u", "love"));

    }
}
