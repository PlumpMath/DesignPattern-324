package com.yujin.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        
        //测试字符串匹配
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]{5}");
        String body="测试验证码2346ds";
        Matcher matcher = pattern.matcher(body);
        //System.out.println(matcher.group().substring(0, 5));
        
        String str1 = "snap.dev.cloud.sengled.com";
        String str2 = "https://null:null/user/";
        System.out.println("str1是否包含：" + str1.contains("cloud.sengled"));
        System.out.println("str2是否包含：" + str2.contains("cloud.sengled"));
        
        String str3 = "https://jx1.element.test.cloud.sengled.cn:9000/zigbee/";
        System.out.println(str3.replace(":8000", ":9000"));
    }
}
