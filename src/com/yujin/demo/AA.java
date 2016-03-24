package com.yujin.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class AA<A, B, C> {

    public void method1() {
        System.out.println("---method1---");
    }
    
    public void method2() {
        System.out.println("---method2---");
    }
    
    public static void main(String[] args) {
        System.out.println("main");
        Animal  animal = new Dog();
        animal.scream();
        Dog dog = new Dog();
        dog.scream();
        Dog.staticMethod();
        /**
         * ������д����ķ�������ʹ����������ת�ͳɸ����������ת�ͺ�ĸ��������ø���ķ�����
         * ��ʵ���õĻ���������д�ķ��������ֽ����෽�������ĸо���
         */
        Animal  animal2 = (Animal)dog;
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
        /**
         * ����StringBuffer����������ַ���
         */
        StringBuffer buf = new StringBuffer(1024*1024*10);
        for (int i = 0; i < 1024*10; i++) {
            System.out.println("buf: " + i);
            buf.append("buf"+ i + "");
        }
        System.out.print("buf: " + buf.toString());
        System.out.print("\n\n");
        //System.out.print("buf reverse: " + buf.reverse());
        String encoding = System.getProperty("file.encoding", "UTF-8");
        System.out.print("encoding: " + encoding + "\n");
        System.out.println(233%11);
        
        for (int i = 0; i <= 0 ; i++) {
            System.out.println("----" + i + "----");
        }
        
        String[] str = {"Aa", "Bb", "Cc", "Dd", "Ee", "Ff", "Gg"};
        printArray(str);
        int location = 2;
        int size = str.length - location -1;
        System.arraycopy(str, location + 1, str, location, size);
        printArray(str);
        /**
         * ��ʾHashMap��Keys��Values�ɵ�����ȡ����
         */
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "Aa");
        map.put("b", "Bb");
        map.put("c", "Cc");
        map.put("d", "Dd");
        map.put("e", "Ee");
        map.put("f", "Ff");
        map.put("g", "Gg");
        map.put("h", "Hh");
        map.put("j", "Jj");
        Collection co = map.values();
        printArray(co.toArray());
        Set set = map.keySet();
        printArray(set.toArray());
        
        ArrayList arrayList = new ArrayList();
        
        System.out.println();
        
    }
    
    public static void printArray(Object[] obj) {
        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i]);
        }
        System.out.println("");
    }
    
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }
    
    private void privateMethod() {
        
    }
    
    protected void protectedMethod() {
        
    }
    
}

class Animal {
    int id;
    String fourColor;
    public Animal() {
        
    }
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
        System.out.println("AnimalCat static method...");
        return -1;
    }
    /**
     * JavaScript���������
     * var data = [1, 2, 3, 4, 5];
     * var sumOfSquare = 0;
     * data.forEach(function(x){
     *      sumOfSquare += x;
     * });
     * �Ҿ�����java�ܲ����������������������е������أ�
     * �б�Ҫ��Object�м�һ��forEache�����أ����뻹��û��Ҫ��
     * @param an
     */
    public static void forEach(AnimalCat an) {
        
    }
}

class Dog extends Animal implements A, AAAA{
    int wight;
    int height;
    String eyeColor;
    public Dog() {
        super();
    }
    public void scream() {
        System.out.println("Dog are scream...");
    }
    public void run() {
        System.out.println("Dog is running...");
    }
    
    /**
     * The method staticMethod() of type Dog must override or implement a supertype method
     * ֤����̬������û����дһ˵����̬�Ķ�����û��ʵ������
     * û��ʵ���Խ������Ķ�̬��
     * @return
     */
//    @Override
//    public static int staticMethod() {
//        System.out.println("Dog static method...");
//        return 1;
//    }
    
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
