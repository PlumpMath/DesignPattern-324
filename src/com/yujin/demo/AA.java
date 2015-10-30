package com.yujin.demo;

import java.util.Arrays;

public class AA {

    public void method1() {
        System.out.println("---method1---");
    }
    
    public void method2() {
        System.out.println("---method2---");
    }
    
    public static void main(String[] args) {
        System.out.println("main");
        Animal animal = new Dog();
        animal.scream();
        Dog dog = new Dog();
        dog.scream();
        /**
         * 子类重写父类的方法，即使将子类向上转型成父类对象，再用转型后的父类对象调用父类的方法，
         * 其实调用的还是子类重写的方法，有种将父类方法擦除的感觉。
         */
        Animal animal2 = (Animal)dog;
        animal2.scream();
        /**
         * 验证二维数组的打印操作
         */
//        int[][][] a = new int[2][2][3];
//        System.out.println(Arrays.deepToString(a));
        /**
         * 验证用位移方式实现两个数的交换操作
         */
//        int aa = 5, bb = 6;
//        System.out.println(aa + " " + bb);
//        aa = aa^bb;
//        bb = bb^aa;
//        aa = aa^bb;
//        System.out.println(aa + " " + bb);
    }
    
}

class Animal {
    int id;
    String fourColor;
    public void scream() {
        System.out.println("animal are scream...");
    }
}

class Dog extends Animal implements A, AAAA{
    int wight;
    int height;
    String eyeColor;
    public void scream() {
        System.out.println("Dog are scream...");
    }
    public void run() {
        System.out.println("Dog is running...");
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Dog is start...");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("Dog is stop...");
    }

    @Override
    public void say() {
        // TODO Auto-generated method stub
        System.out.println("Dog is say...");
    }
}

interface A {
    public static final int id = 100;
    public abstract void say();
    public abstract void run();
}

interface AAAA extends A {
    public static final long _id = 101;
    public void start();
    public void stop();
}
