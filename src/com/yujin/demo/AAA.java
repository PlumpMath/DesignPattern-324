package com.yujin.demo;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AAA<A, B> extends AA {

    @Override
    public void method1() {
        // TODO Auto-generated method stub
        super.method1();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(10);
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        for (String str : list) {
            System.out.println(str);
        }
        
        /**
         * 
         */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String input[] = { "2013-10-01 Vancouver, B.C.", 
                           "1248-03-01 Ottawa, ON",
                           "1323-06-06 Toronto, ON" };
        for (int i = 0; i < input.length; i++) {
          ParsePosition pp = new ParsePosition(0);
          Date d = formatter.parse(input[i], pp);
          if (d == null) {
            System.err.println("Invalid date in " + input[i]);
            continue;
          }
          String location = input[i].substring(pp.getIndex());
          System.out.println(" on " + d + " in " + location);
        }
        /**
         * 
         */
        MyCookiePolicy.var1.shouldAccept("var1 url", "cookie");
        MyCookiePolicy.var2.shouldAccept("var2 url", "cookie");
    }

    ThreadLocal<Student> tl = new ThreadLocal<Student>(){

        @Override
        protected Student initialValue() {
            // TODO Auto-generated method stub
            return super.initialValue();
        }
        
    };
    
}
