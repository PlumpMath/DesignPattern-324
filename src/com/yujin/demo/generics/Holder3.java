package com.yujin.demo.generics;
/**
 * ����ʹ��Object�����Ǹ�ϲ����ʱ��ָ�����ͣ������Ժ��پ�������ʹ��ʲô���͡�
 * Ҫ�ﵽ���Ŀ�ģ���Ҫʹ�����Ͳ������ü�����ס�������������档Ȼ����ʹ��������ʱ������ʵ�ʵ������滻Щ������
 * 
 * �����Java���͵ĺ��ĸ�����߱�������ʹ��ʲô���ͣ�Ȼ����������㴦��һ��ϸ�ڡ�
 * 
 * һ����ԣ��������Ϊ���������������Ͳ�ֻ࣬�����������������Ͳ������ˣ�
 * �Ժ����ǻῴ������ʹ�÷���ʱ������ֻ��Ҫָ�����ǵ������Լ����Ͳ������ɡ�
 * @author yujin
 *
 * @param <T>
 */
public class Holder3<T> {
	
	private T a;
	public Holder3(T a) {
		this.a = a;
	}
	
	public void set(T a) {
		this.a = a;
	}
	
	public T get() {
		return a;
	}
	
	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile mobile = h3.get(); //No cast needed
	}
}

class Automobile {}
