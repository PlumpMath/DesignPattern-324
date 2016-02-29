package com.yujin.demo.exception;

public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if (i == 1) return;
            System.out.println("Point 2");
            if (i == 2) return;
            System.out.println("Point 3");
            if (i == 3) return;
            return;
        } catch (Exception e) {
            System.out.println("Caught try block");
        } finally {
            System.out.println("finally try block");
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            f(i);
        }
    }
}
