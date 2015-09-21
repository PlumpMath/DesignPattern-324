package com.yujin.demo;

public class StringDemo {

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1.hashCode());
        System.out.println(s1);
        s1 += "def";
        System.out.println(s1.hashCode());
        System.out.println(s1);
        
        String s2 = s1.concat("123");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        
        String s3 = s1.toUpperCase();
        System.out.println("s1: " + s1);
        System.out.println("s3: " + s3);
        
        String s4 = "photo.jpg";
        if (s4.indexOf(".jpg") > -1) {
            System.out.println("图片文件");
        }
        
        String login = "   \t\ntom\r\n";
        System.out.println("login: " + login);
        login += login.trim();
        System.out.println("login: " + login);
        
        String ss1 = "abc";
        String ss2 = "abc";
        String ss3 = "ab" + "c";
        System.out.println(ss1 == ss2);
        System.out.println(ss1 == ss3);
        
    }
}
