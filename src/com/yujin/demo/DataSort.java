package com.yujin.demo;

public class DataSort {

    public static void sort(int[] a) {
        long start = System.currentTimeMillis();
        System.out.println("startTime: " + start);
        for (int i = a.length; i > 0 ; i--) {
            for (int j = 0; j < i-1; j++) {
                if (a[j] > a[j+1]) {
                    swip(a, j, j+1);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("endTime: " + end);
        long time = end - start;
        System.out.println("take time: " + (time));
    }
    
    public static void swip(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
 }
