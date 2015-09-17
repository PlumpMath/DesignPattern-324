package com.yujin.demo.annotation;

@MyAnnotation(arrayAttrs = { "aaa", "bbb", "ccc" })
@IAnnotation
public class AnnotationTest {

    public static void main(String[] args) {
        Class<?> cls = MyAnnotation.class;
        if (cls.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println(cls.getName());
            MyAnnotation myAnnotation = (MyAnnotation)cls.getAnnotation(MyAnnotation.class);
            myAnnotation.name();
        }
    }
}
