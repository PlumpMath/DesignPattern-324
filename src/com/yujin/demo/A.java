package com.yujin.demo;
/**
 * 静态代码块与构造方法加载顺序验证
 * @author yujin
 *
 */
public class A {
	public A() {
		System.out.println("A class Construct");
	}
	static {
		System.out.println("A static 1");
	}
	static {
		System.out.println("A static 2");
	}
	
	public static void main(String[] args) {
		BB b = new BB();
		b.say();
	}
}

class BB extends A {
	
	public BB() {
		System.out.println("B class Construct");
	}
	static {
		System.out.println("B static 1");
	}
	static {
		System.out.println("B static 2");
	}
	public void say() {
		System.out.println("say hello");
	}
}
