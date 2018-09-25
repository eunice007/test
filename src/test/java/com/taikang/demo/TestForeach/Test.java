package com.taikang.demo.TestForeach;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eunice
 * @date 2018/9/10
 */
public class Test {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4};
        List<Integer> list = Arrays.asList(array);

//        for ()

        /*for (Integer i : list) {
            if (i == 1) {
                list.remove(i); //java.lang.UnsupportedOperationException
            }
        }*/

        System.out.println(list);

    }
}
