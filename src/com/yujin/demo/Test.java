package com.yujin.demo;

public class Test extends Object {

    public static final Student stu = new Student();
    public static void main(String[] args) {
        AAA a = new AAA(){
            public void method3() {
                System.out.println("inner class method3");
            }
            
            public void method4() {
                System.out.println("inner class method4");
            }
        };
        a.method1();
        a.method2();
        
        System.out.println("before: " + stu.id);
        stu.id = 10001;
        System.out.println("after: " + stu.id);
        
        
        System.out.println("before: " + VVV.str);
        VVV.str.replace('s', 'a');
        System.out.println("after: " + VVV.str);
        
        
        Student stu1 = new Student(1001L, "wang");
        Student stu2 = new Student(1002L, "li");
        System.out.println("stu1: " + stu1);
        System.out.println("stu2: " + stu2);
        System.out.println("stu1 hashCode: " + stu1.hashCode());
        System.out.println("stu2 hashCode: " + stu2.hashCode());
        System.out.println(stu1.equals(stu2));
    }
    
    
}
