package com.yujin.sxt.proxy.compile;

import java.lang.reflect.Method;

import com.yujin.sxt.proxy.Moveable;

public class Test2 {

    public static void main(String[] args) {
        Method[] methods = Moveable.class.getMethods();
        for (Method m:methods) {
            System.out.println(m);
        }
    }
}
