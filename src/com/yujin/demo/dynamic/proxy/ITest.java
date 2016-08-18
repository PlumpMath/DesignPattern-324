package com.yujin.demo.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ITest {

	public interface IUser {
		
		int add(int a, int b);
	}
	
	public static void main(String[] args) {
		IUser iuser = (IUser)Proxy.newProxyInstance(IUser.class.getClassLoader(), new Class<?>[]{IUser.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				Integer a = (Integer) args[0];
				Integer b = (Integer) args[1];
				System.out.println("方法名：" + method.getName());
				System.out.println("参数：" + a + "," + b);
				Integer sum = a + b;
				return sum;
			}
		});
		System.out.println(iuser.add(7, 9) + " ");
	}
	
}
