package com.yujin.demo;

public class InnerClass {
    static {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }
    public InnerClass() {
        System.out.println("3");
    }
    
    public static void main(String[] args) {
//        Child c = new Child();
//        c.play();
        InnerClass.A a = new InnerClass.A();
        a.run();
    }
    
    static class A {
        static {
            System.out.println("static-1");
        }
        public A() {
            System.out.println("static-2");
        }
        public void run() {
            System.out.println("static-3");
        }
    }
}

class Child extends InnerClass {
    static {
        System.out.println("2-1");
    }
    
    static {
        System.out.println("2-2");
    }
    
    public Child() {
        System.out.println("2-3");
    }
    
    public void play() {
        System.out.println("2-4");
    }
}
