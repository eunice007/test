package com.taikang.demo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eunice
 * @date 2018/9/5
 */
public class Test {
    public static void main(String[] args) {
        /*List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        int i = numElementsInCommon(list1, list2);
        System.out.println(i);*/

        Object[] objectArr = new Long[1];   //编译通过
        objectArr[0] = "123";   //运行时报错 ArrayStoreException

//        List<Object> objectList= new ArrayList<Long>(); //编译不通过

        ArrayList<Object> objects = new ArrayList<>();


    }

    /**
     * 统计list1和list2中相同元素的个数
     * @param list1
     * @param list2
     * @return
     */
    public static int numElementsInCommon(List<?> list1, List<?> list2){
        //  list1.add("1"); //不能往List<?>中添加任何元素
        int result = 0;
        for (Object object: list1
             ) {
            if (list2.contains(object)){
                result++;
            }
        }
        return result;
    }
}
