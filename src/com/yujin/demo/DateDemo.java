package com.yujin.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateDemo {

    public static void main(String[] args) throws Exception{
        long now = System.currentTimeMillis();
        System.out.println("now: " + now);
        Date date = new Date(now);
        //过时的API, SUN公司不推荐使用,因为这个算法有误,SUN公司用新的类来替换了算历法的算法
        System.out.println("year: " + date.getYear());//错误
        System.out.println("month: " + date.getMonth());//正确
        System.out.println("day: " + date.getDay());//错误
        System.out.println("hours: " + date.getHours());//错误
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println("====================================");
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        System.out.println("year: " + c.getWeekYear());
        System.out.println("month: " + (c.get(Calendar.MONTH) + 1));
        System.out.println("day: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("hours: " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("====================================");
        
        Date date2 = new Date();//默认是当前时间
        System.out.println(date2);
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        dft.format(date2);
        System.out.println(dft.format(date2));
        
        String s = "1971-9-12";
        DateFormat dft2 = new SimpleDateFormat("yyy-MM-dd");
        Date date3 = dft2.parse(s);
        System.out.println(dft2.format(date3));
    }
}
