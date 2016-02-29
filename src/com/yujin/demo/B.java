package com.yujin.demo;

public class B extends AbstractB{

    @Override
    public void method3(String str) {
        System.out.println("method3...");
    }

    @Override
    public void method4(String str, Object obj) {
        System.out.println("method4...");
    }

    public static void main(String[] args) {
		for (int i=0,j=0; ; ) {
			if (i==5) {
				break;
			}
			System.out.println("i: " + i + " j: " + j);
			i++;
		}
	}
}
