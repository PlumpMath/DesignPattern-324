package com.yujin.demo;

public class AutoBoxDemo {

    public static void main(String[] args) {
        Object obj = 3.509f;
        System.out.println(obj instanceof Float);
        Object obj2 = 3.509d;
        System.out.println(obj2 instanceof Double);
        
        Integer a = new Integer("3145");
        System.out.println("int: " + a.intValue());
        System.out.println("float: " + a.floatValue());
        System.out.println("double: " + a.doubleValue());
    }
}
