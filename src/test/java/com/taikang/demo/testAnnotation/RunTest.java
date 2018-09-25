package com.taikang.demo.testAnnotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Eunice
 * @date 2018/9/6
 */
@Slf4j
public class RunTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> simpleClass = Class.forName("com.taikang.demo.testAnnotation.Simple");

        Method[] declaredMethods = simpleClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
               if (m.isAnnotationPresent(ExceptionTest.class)){ //该方法如果被@ExceptionTest注解
                   tests++;
                   try{
                       m.invoke(null);
                       log.info("Test {} failed: no exception", m); //运行该方法, 没有抛出异常
                   }catch (InvocationTargetException e) {  //当被调用的方法的内部抛出了异常而没有被捕获时，将由此异常接收
                       Throwable cause = e.getCause();
                       Class<? extends Exception> annotationClass = m.getAnnotation(ExceptionTest.class).value();
                       if (annotationClass.isInstance(cause)){
                           passed++;
                           log.info("Test {} success: throw {}", m, m.getAnnotation(ExceptionTest.class).value());
                       }else {
                           log.info("Test {} failed: 抛出异常的类型不符");
                       }
                   } catch (Exception e) {
                       log.info("抛出了不关心的异常");
                   }
               }
        }

        /*
        13:28:29.945 [main] INFO com.taikang.demo.testAnnotation.RunTest - Test public static void com.taikang.demo.testAnnotation.Simple.m3() failed: no exception
        13:28:29.980 [main] INFO com.taikang.demo.testAnnotation.RunTest - Test public static void com.taikang.demo.testAnnotation.Simple.m1() success: throw class java.lang.ArithmeticException
        13:28:29.981 [main] INFO com.taikang.demo.testAnnotation.RunTest - Test {} failed: 抛出异常的类型不符
        */
    }
}
