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
        Dog.staticMethod();
        /**
         * 子类重写父类的方法，即使将子类向上转型成父类对象，再用转型后的父类对象调用父类的方法，
         * 其实调用的还是子类重写的方法，有种将父类方法擦除的感觉。
         */
        Animal animal2 = (Animal)dog;
        animal2.scream();
        Animal.staticMethod();
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
    
    /**
     * 验证静态方法能否被重写(Override)
     * 验证结果：
     *      所谓静态，就是在运行时，虚拟机已经认定此方法属于哪个类。
     *      专业术语有严格的含义，用语要准确."重写"只能适用于实例方法.不能用于静态方法.对于静态方法，
     *      只能隐藏(刚才的例子可以重写那只是形式上的 ，并不满足多态的特征，所以严格说不是重写)。
     *      静态方法的调用不需要实例化吧.不实例化也就不能用多态了，也就没有所谓的父类引用指向子类实例.
     *      因为不能实例化 也就没有机会去指向子类的实例。所以也就不存在多态了。
     * @return
     */
    public static int staticMethod() {
        System.out.println("Animal static method...");
        return -1;
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
    
    /**
     * The method staticMethod() of type Dog must override or implement a supertype method
     * 证明静态方法就没有重写一说，静态的东西就没有实例对象，
     * 没有实例对角哪来的多态，没有多态哪儿来的继承，没继承哪来的重写一说。
     * @return
     */
//    @Override
//    public static int staticMethod() {
//        System.out.println("Dog static method...");
//        return 1;
//    }
//    
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
