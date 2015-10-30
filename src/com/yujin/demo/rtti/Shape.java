package com.yujin.demo.rtti;

import java.util.Arrays;
import java.util.List;

/**
 * 本章将讨论Java是如何让我们在运行时识别对象和类的信息的。
 * 主要有两种方式：一种是"传统的"RTTI(Run-Time Type Information)，一种是反射机制
 * RTTI它假定我们在编译时已经知道了所有的类型。
 * 反射机制允许我们在运行时发现和使用类的信息。
 * 
 * @author yujin
 *
 */
public abstract class Shape {

    public abstract String toString();
    public void draw() {
        System.out.println(this + ".draw()");
    }
    
    /**
     * 在main方法中测试
     */
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), 
                new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
        /**
         * 运行结果：
         * Circle.draw()
         * Square.draw()
         * Triangle.draw()
         */
    }
}

class Circle extends Shape {
    
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    
    public String toString() {
        return "Triangle";
    }
}
