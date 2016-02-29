package com.yujin.demo;

import java.util.Random;

public class SortClient {

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        //DataSort.print(a);
        DataSort.sort(a);
        //DataSort.print(a);
    }
}
