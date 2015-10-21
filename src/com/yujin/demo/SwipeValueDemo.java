package com.yujin.demo;
/**
 * 交换两个变量的值的三种方法：借助中间量交换，数值相加减交换，位移运算交换
 * @author yujin
 *
 */
public class SwipeValueDemo {

	public static void main(String[] args) {
		int a = 5, b = 6;
		System.out.println("原始值 a=" + a + " b=" + b);
		/**
		 * 借助中间量交换
		 */
		int temp = a;
		a = b;
		b = temp;
		System.out.println("借助中间量交换 a=" + a + " b=" + b);
		
		/**
		 * 数值相加减交换
		 */
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("数值相加减交换 a=" + a + " b=" + b);
		
		/**
		 * 位移运算交换
		 */
		a = a^b;
		b = b^a;
		a = a^b;
		System.out.println("位移运算交换 a=" + a + " b=" + b);
	}
}
