package com.yujin.demo.exception;

class ThreeExceptin extends Exception {}

public class FinallyWorks {
    static int count = 0;
    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0)
                    throw new ThreeExceptin();
            } catch(ThreeExceptin e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}
