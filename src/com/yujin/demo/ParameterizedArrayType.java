package com.yujin.demo;
/**
 * ͨ���������뷺�Ͳ��ܺܺõؽ�ϣ��㲻��ʵ�������в��������͵����顣
 * @author yujin
 *
 */
public class ParameterizedArrayType {

	public static void main(String[] args) {
		Integer[] ints = {1, 2, 3, 4, 5};
		Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
		Integer[] ints2 = (Integer[]) new ClassParameter().f(ints);
		Double[] doubles2 = (Double[]) new ClassParameter().f(doubles);
		ints2 = MethodParameter.f(ints);
		doubles2 = MethodParameter.f(doubles);
		for (Integer ints1 : ints2) {
			System.out.print(ints1 + " ");
		}
		System.out.println();
		for (Double double1 : doubles2) {
			System.out.print(double1 + " ");
		}
	}
}

class ClassParameter<T> {
	public T[] f(T[] arg) {
		return arg;
	}
}

class MethodParameter {
	public static <E> E[] f(E[] arg) {
		return arg;
	}
}
