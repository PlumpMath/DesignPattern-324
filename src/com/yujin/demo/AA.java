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
         * ������д����ķ�������ʹ����������ת�ͳɸ����������ת�ͺ�ĸ��������ø���ķ�����
         * ��ʵ���õĻ���������д�ķ��������ֽ����෽�������ĸо���
         */
        Animal animal2 = (Animal)dog;
        animal2.scream();
        Animal.staticMethod();
        /**
         * ��֤��ά����Ĵ�ӡ����
         */
//        int[][][] a = new int[2][2][3];
//        System.out.println(Arrays.deepToString(a));
        /**
         * ��֤��λ�Ʒ�ʽʵ���������Ľ�������
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
     * ��֤��̬�����ܷ���д(Override)
     * ��֤�����
     *      ��ν��̬������������ʱ��������Ѿ��϶��˷��������ĸ��ࡣ
     *      רҵ�������ϸ�ĺ��壬����Ҫ׼ȷ."��д"ֻ��������ʵ������.�������ھ�̬����.���ھ�̬������
     *      ֻ������(�ղŵ����ӿ�����д��ֻ����ʽ�ϵ� �����������̬�������������ϸ�˵������д)��
     *      ��̬�����ĵ��ò���Ҫʵ������.��ʵ����Ҳ�Ͳ����ö�̬�ˣ�Ҳ��û����ν�ĸ�������ָ������ʵ��.
     *      ��Ϊ����ʵ���� Ҳ��û�л���ȥָ�������ʵ��������Ҳ�Ͳ����ڶ�̬�ˡ�
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
     * ֤����̬������û����дһ˵����̬�Ķ�����û��ʵ������
     * û��ʵ���Խ������Ķ�̬��û�ж�̬�Ķ����ļ̳У�û�̳���������дһ˵��
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
