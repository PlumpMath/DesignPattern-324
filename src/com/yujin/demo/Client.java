package com.yujin.demo;

import java.util.Random;

public class Client {

    public static void main(String[] args) {
        B b = new B();
        b.method2(1);
//        for (int i = 0; i < 10; i++) {
            Random ran = new Random();
            int num = ran.nextInt(1000);
            while (num%2==0) {
                System.out.println(num + "/" + 2 + "=" + num);
                num %= 2;
            }
//        }
    }
}
