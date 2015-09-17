package com.yujin.demo.algorithm;

import java.util.Collection;

/**
 * 
 * @author yujin
 * 八大排序算法: 冒择路(入)兮(希)快归堆   冒失的选择一条路很快就会进入坟墓
 * 1.冒泡
 * 2.选择
 * 3.插入
 * 4.希尔
 * 5.快速
 * 6.归并
 * 7.堆
 * 8.基数
 */
public class SortAlgorithm {

    /**
     * 插入排序
     * @param obj
     */
    public static void insertSort(Object[] obj) {
        for (int i = 0; i < obj.length - 1; i++) {
            int j = i;
            Compareable target =  (Compareable)obj[j];
            while (j > 0 && target.compareTo(obj[j - 1]) == -1) {
                Compareable temp = (Compareable)obj[j];
                obj[j] = obj[j - 1];
                obj[j - 1] = temp;
                j--;
            }
        }
    }
    
    /**
     * 希尔排序-是插入排序一种更高效的改进版本
     * @param obj
     */
    public static void shellSort(Compareable[] obj) {
        int gap = obj.length / 2;
        
        while (gap >= 1) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < obj.length; i++) {
                int j = 0;
                Compareable temp = obj[i];
                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp.compareTo(obj[j]) == -1; j = j- gap) {
                    obj[j + gap] = obj[j];
                }
                obj[j + gap] = temp;
            }
            gap = gap / 2; // 减小增量
        }
    }
    
    /**
     * 选择排序
     * @param obj
     */
    public static void selectSort(Compareable[] obj) {
        Compareable temp;
        int nIndex = 0;
        for (int i = 0; i < obj.length - 1; i++) {
            nIndex = i;
            for (int j = i + 1; j < obj.length; j++) {
                if (obj[j].compareTo(obj[nIndex]) == -1) {
                    nIndex = j;
                }
            }
            if (nIndex != i) {
                temp = obj[i];
                obj[i] = obj[nIndex];
                obj[nIndex] = temp;
            }

        }
    }
    
    /**
     * 冒泡排序
     * @param obj
     */
    public static void bubbleSort(Compareable[] obj) {
        for (int i = 0; i < obj.length; i++) {
            for (int j = i; j < obj.length; j++) {
                if (obj[i].compareTo(obj[j]) == 1) {
                    Compareable temp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = temp;
                }
            }
            for (Compareable compareable : obj) {
                Student stu = (Student)compareable;
                System.out.print(stu.id + " ");
            }
            System.out.println();
        }
    }

}
