package com.yujin.demo.generics;

import java.util.ArrayList;

public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1 == c2);
        
        System.out.println();
        String str1 = "class java.util.ArrayList";
        String str2 = "class java.util.ArrayList";
        System.out.println("str1: " + str1.hashCode());
        System.out.println("str2: " + str2.hashCode());
        System.out.println(str1 == str2);
        System.out.println();
        String str3 = new String("class java.util.ArrayList");
        String str4 = new String("class java.util.ArrayList");
        System.out.println("str3: " + str3.hashCode());
        System.out.println("str4: " + str4.hashCode());
        System.out.println(str3 == str4);
        
        System.out.println();
        String s1 = "ja";
        String s2 = "va";
        String s3 = "java";
        String s4 = s1 + s2;
        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());
        System.out.println("s3: " + s3.hashCode());
        System.out.println("s4: " + s4.hashCode());
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true
        
        System.out.println();
        Integer i=100;  
        Integer j=100;  
        System.out.println(i==j);  // ¥Ú”° true

        Integer ii=200;  
        Integer jj=200;  
        System.out.println(ii==jj);  //¥Ú”°false
        
        Object obj = new Object();
    }
}
