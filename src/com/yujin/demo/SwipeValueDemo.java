package com.yujin.demo;
/**
 * ��������������ֵ�����ַ����������м�����������ֵ��Ӽ�������λ�����㽻��
 * @author yujin
 *
 */
public class SwipeValueDemo {

	public static void main(String[] args) {
		int a = 5, b = 6;
		System.out.println("ԭʼֵ a=" + a + " b=" + b);
		/**
		 * �����м�������
		 */
		int temp = a;
		a = b;
		b = temp;
		System.out.println("�����м������� a=" + a + " b=" + b);
		
		/**
		 * ��ֵ��Ӽ�����
		 */
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("��ֵ��Ӽ����� a=" + a + " b=" + b);
		
		/**
		 * λ�����㽻��
		 */
		a = a^b;
		b = b^a;
		a = a^b;
		System.out.println("λ�����㽻�� a=" + a + " b=" + b);
	}
}
