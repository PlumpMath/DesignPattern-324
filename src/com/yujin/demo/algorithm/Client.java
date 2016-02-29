package com.yujin.demo.algorithm;

import java.util.Random;

/**
 * 
 * @author yujin
 * 创建100个Student对象,用不同排序算法进行排序
 * 创建100个Cat对象,用不同排序算法进行排序
 * 
 */
public class Client {

    public static void main(String[] args) {
        //Collections.sort(list, c);
        Random random = new Random();
        Student[] stu = new Student[10];
        int[] list = new int[10];
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student(random.nextInt(10), random.nextInt(10));
            stu[i].setName("a" + i);
            list[i] = random.nextInt(10);
        }
        System.out.println("排序前:");
        for (int j = 0; j < stu.length; j++) {
            System.out.print(stu[j]);
        }
        System.out.println();
        //SortAlgorithm.insertSort(stu);
        //SortAlgorithm.shellSort(stu);
        SortAlgorithm.bubbleSort(stu);
        //SortAlgorithm.selectSort(stu);
        System.out.println("排序后:");
        for (int j = 0; j < stu.length; j++) {
            System.out.print(stu[j]);
        }
        System.out.println();
        
    }
}
