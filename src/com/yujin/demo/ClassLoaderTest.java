package com.yujin.demo;

import java.lang.reflect.Constructor;

/**
 * 所有的类都是在对其第一次使用时，动态加载到JVM中的。
 * 当程序创建第一个对类的静态成员的引用时，就会加载这个类。
 * 这个证明构造器也是类的静态方法，即使在构造器之前并没有使用static关键字。
 * 因此，使用new操作符创建类的新对象也会被 当作的静态成员的引用。
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
