package com.taikang.demo.core.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Eunice
 * @date 2018/8/15
 */
public class DateUtil {
    public static Date getDeclaredDate(int days){
        Calendar calendar = new GregorianCalendar(1900, 0, -1);
        calendar.add(5, days);
        return calendar.getTime();
    }
}
