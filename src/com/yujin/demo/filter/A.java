package com.yujin.demo.filter;

public class A implements Cloneable {
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
    
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 9, 7, 10, 5, 6, 7, 2};
        System.out.print("排序前：");
        printArray(a);
        /**
         * 演示插入排序
         */
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("排序后：");
        printArray(a);
    }
}
