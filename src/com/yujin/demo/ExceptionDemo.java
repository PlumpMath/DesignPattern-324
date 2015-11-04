package com.yujin.demo;

public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1 come in catch block");
            try {
                throw new Exception();
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("1-2 come in catch block");
            } finally {
                System.out.println("1-2 come in finally block");
            }
        } finally {
            System.out.println("1 come in finally block");
        }
    }
}
