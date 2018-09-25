package com.taikang.demo.testRandom;

import java.util.Random;

/**
 * @author Eunice
 * @date 2018/9/10
 */
public class Test {
    public static void main(String[] args) {
        /*System.out.println(Integer.MIN_VALUE);  //-2147483648
        System.out.println(Math.abs(Integer.MIN_VALUE));    //-2147483648

        System.out.println(Math.abs(-100)); //100
*/


        Random random = new Random();
        for (int i=0; i<10; i++){
            System.out.println(random.nextInt(10));
        }
    }
}
