package com.yujin.demo;

import java.lang.reflect.Constructor;

/**
 * ���е��඼���ڶ����һ��ʹ��ʱ����̬���ص�JVM�еġ�
 * �����򴴽���һ������ľ�̬��Ա������ʱ���ͻ��������ࡣ
 * ���֤��������Ҳ����ľ�̬��������ʹ�ڹ�����֮ǰ��û��ʹ��static�ؼ��֡�
 * ��ˣ�ʹ��new��������������¶���Ҳ�ᱻ �����ľ�̬��Ա�����á�
 * @author yujin
 *
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
//        Animal2 animal = new Animal2();
        Animal2 animal2 = new Bird();
        animal2.sing();
//        Bird bird = new Bird();
//        bird.scream();
        try {
            Class cls = Class.forName("Animal2");
            Class cls2 = Animal2.class;
            Constructor[] mConstructor = cls.getConstructors();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Animal2 {
    static  {
        System.out.println("Animal2 static 1");
    }
    static  {
        System.out.println("Animal2 static 2");
    }
    public Animal2() {
        System.out.println("Animal2 Construct");
    }
    public void run() {
        System.out.println(this + " can run...");
    }
    public void scream() {
        System.out.println(this + " can scream...");
    }
    public void sing() {
        System.out.println("brid sing...");
    }
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
class Bird extends Animal2 {
    static {
        System.out.println("Bird static 1");
    }
    static  {
        System.out.println("Bird static 2");
    }
    public Bird() {
        System.out.println("Bird Construct");
    }
    public void sing() {
        System.out.println("brid sing.....");
    }
}
