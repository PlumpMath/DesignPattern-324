package com.yujin.demo.reflect;

import java.lang.reflect.Field;  
import java.lang.reflect.Method;  

public class UserBean {  
    private Integer id;  
    private int age;  
    private String name;  
    private String address;  
     
    public UserBean(){  
       System.out.println("实例化");  
    }  
     
    public Integer getId() {  
       return id;  
    }  
    public void setId(Integer id) {  
       this.id = id;  
    }  
    public int getAge() {  
       return age;  
    }  
    public void setAge(int age) {  
       this.age = age;  
    }  
    public String getName() {  
       return name;  
    }  
    public void setName(String name) {  
       this.name = name;  
    }  
    public String getAddress() {  
       return address;  
    }  
    public void setAddress(String address) {  
       this.address = address;  
    }  
    
    public static void main(String[] args) throws Exception {
        /* 
         * 实列化类 方法1 
         */  
        //String classPath = "com.whbs.bean.UserBean";  
        //Class cla = Test1.class.getClassLoader().loadClass(classPath);  
        //Object ob = cla.newInstance();  
        /* 
         * 实列化类 方法2 
         */  
        UserBean bean = new UserBean();  
        bean.setId(100);  
        bean.setAddress("武汉");  
         
        //得到类对象  
        Class userCla = (Class) bean.getClass();  
         
        /* 
         * 得到类中的所有属性集合 
         */  
        Field[] fs = userCla.getDeclaredFields();  
        for(int i = 0 ; i < fs.length; i++){  
            Field f = fs[i];  
            f.setAccessible(true); //设置些属性是可以访问的  
            Object val = f.get(bean);//得到此属性的值     
         
            System.out.println("name:"+f.getName()+"\t value = "+val);  
             
            String type = f.getType().toString();//得到此属性的类型  
            if (type.endsWith("String")) {  
               System.out.println(f.getType()+"\t是String");  
               f.set(bean,"12") ;        //给属性设值  
            }else if(type.endsWith("int") || type.endsWith("Integer")){  
               System.out.println(f.getType()+"\t是int");  
               f.set(bean,12) ;       //给属性设值  
            }else{  
               System.out.println(f.getType()+"\t");  
            }  
             
        }  
         
        /* 
         * 得到类中的方法 
         */  
        Method[] methods = userCla.getMethods();  
        for(int i = 0; i < methods.length; i++){  
            Method method = methods[i];  
            if(method.getName().startsWith("get")){  
               System.out.print("methodName:"+method.getName()+"\t");  
               System.out.println("value:"+method.invoke(bean));//得到get 方法的值  
            }  
        }  
    }
}  
