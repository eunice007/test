package com.taikang.demo.testAnnotation;

/**
 * @author Eunice
 * @date 2018/9/6
 */
public class Simple {
    @ExceptionTest(ArithmeticException.class)
    public static void m1(){    //会抛出ArithmeticException异常
        int i = 0;
        i = i/i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2(){    //会抛出数组下表越界异常
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3(){    //不会抛出异常

    }
}
