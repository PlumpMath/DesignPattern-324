package com.yujin.demo;

import java.util.Arrays;

public class aa {

	public void method1() {
		System.out.println("---method1---");
	}
	
	public void method2() {
		System.out.println("---method2---");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		Animal animal = new Dog();
		Dog dog = new Dog();
		Animal animal2 = (Animal)dog;
		int[][][] a = new int[2][2][3];
		System.out.println(Arrays.deepToString(a));
		int aa = 5, bb = 6;
		System.out.println(aa + " " + bb);
		aa = aa^bb;
		bb = bb^aa;
		aa = aa^bb;
		System.out.println(aa + " " + bb);
	}
	
}

class Animal {
	int id;
	String fourColor;
	public void scream() {
		System.out.println("animal are scream...");
	}
}

class Dog extends Animal implements A, AAAA{
	int wight;
	int height;
	String eyeColor;
	
	public void run() {
		System.out.println("Dog is running...");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void say() {
		// TODO Auto-generated method stub
		
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
