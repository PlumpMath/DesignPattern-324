package com.yujin.demo.generics;

/**
 * Ԫ�飺���ǽ�һ�����ֱ�Ӵ���洢�����е�һ����һ��������������������ȡ����Ԫ�أ����ǲ����������д���µĶ���
 * �������Ҳ��Ϊ���ݴ��Ͷ��󣬻���ʹ��
 * @author yujin
 *
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B> {

	public final A first;
	public final B second;
	
	public TwoTuple(A a, B b) {
		first = a;
		second = b;
	}
	
	public String toString() {
		return "(" + first + "," + second + ")";
	}
	
	//TupleTest
	public static void main(String[] args) {
		
		
	}
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
	public final C third;

	public ThreeTuple(A a, B b, C c) {
		super(a, b);
		third = c;
	}
	public String toString() {
		return "(" + first + "," + second + "," + third +")";
	}
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	public final D fourth;

	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		fourth = d;
	}

	public String toString() {
		return "(" + first + "," + second + "," + third + "," + fourth + ")";
	}
	
	class innerClass{
		class innerClass2 {
			
		}
	}
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
	public final E fifth;

	public FiveTuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		fifth = e;
	}

	public String toString() {
		return "(" + first + "," + second + "," + third + "," + fourth + ","
				+ fifth + ")";
	}
}
