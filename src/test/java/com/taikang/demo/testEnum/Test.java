package com.taikang.demo.testEnum;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * @author Eunice
 * @date 2018/9/5
 */
@Slf4j
public class Test {
    public static void main(String[] args) {

        test(ExtendOperationEnum.class, 3, 2);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y){
        for (Operation op : opSet.getEnumConstants()){
            System.out.println(op.apply(x, y));
        }
    }
}
