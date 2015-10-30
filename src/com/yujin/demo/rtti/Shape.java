package com.yujin.demo.rtti;

import java.util.Arrays;
import java.util.List;

/**
 * ���½�����Java�����������������ʱʶ�����������Ϣ�ġ�
 * ��Ҫ�����ַ�ʽ��һ����"��ͳ��"RTTI(Run-Time Type Information)��һ���Ƿ������
 * RTTI���ٶ������ڱ���ʱ�Ѿ�֪�������е����͡�
 * ���������������������ʱ���ֺ�ʹ�������Ϣ��
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
     * ��main�����в���
     */
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), 
                new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
        /**
         * ���н����
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
