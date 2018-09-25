package com.taikang.demo.strategy2;

/**
 * 宿主类
 *
 * @author Eunice
 * @date 2018/9/4
 */
public class Host {

    //具体策略类 是宿主类的 私有内部类
    private static class StrLengthCompare implements Compare<String>{
        @Override
        public int compare(String p1, String p2) {
            return p1.length()-p2.length();
        }
    }

    //具体策略类
    private static class IntegerCompare implements Compare<Integer>{
        @Override
        public int compare(Integer p1, Integer p2) {
            return p1 - p2;
        }
    }

    //导出公有静态域
    public static final Compare STRING_LENGTH_COMPARE = new StrLengthCompare();

    public static final Compare INTEGER_COMPARE = new IntegerCompare();

}
