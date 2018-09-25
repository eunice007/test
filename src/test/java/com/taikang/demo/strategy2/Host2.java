package com.taikang.demo.strategy2;

/**
 * @author Eunice
 * @date 2018/9/4
 */
public class Host2 {

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

    private static final StrLengthCompare STRING_LENGTH_CONPARE = new StrLengthCompare();
    private static final IntegerCompare INTEGER_COMPARE = new IntegerCompare();

    //用静态工厂方法 导出具体策略的实例
    public static Compare getCompare(ConcreteStrategy concreteStrategy){
        if ("StrLengthCompare".equals(concreteStrategy.name())){
            return STRING_LENGTH_CONPARE;
        } else if ("IntegerCompare".equals(concreteStrategy.name())){
            return INTEGER_COMPARE;
        } else {
            throw new RuntimeException("没有该策略");
        }

    }
}
