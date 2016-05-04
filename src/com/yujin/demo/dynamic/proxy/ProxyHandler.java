package com.yujin.demo.dynamic.proxy;

import java.lang.reflect.*;

public class ProxyHandler implements InvocationHandler {

	private Object proxied;   
	
	public ProxyHandler(Object object) {
		this.proxied = object;
	}
	
	/**
	 * 第一个参数既是代理类实例，
	 * 第二个参数是被调用的方法对象
	 * 第三个方法是调用参数。
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return  method.invoke( proxied, args); 
	}

	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		Subject sub = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(real));
		sub.dosomthing();
	}
}
