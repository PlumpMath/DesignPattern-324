package com.yujin.demo.singleton;

/**
 * 这个类可以满足基本要求，但是，像这样毫无线程安全保护的类，如果我们把它放入多线程的环境下，肯定就会出现问题了，
 * 如何解决？我们首先会想到对getInstance方法加synchronized关键字
 * @author yujin
 *
 */
public class Singleton {
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static Singleton instance = null;
	
	private Singleton () {
		
	}
	/**
	 * 静态方法构建实例
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			return new Singleton();
		}
		return instance;
	}
	
	public Object readResolve() {  
        return instance;  
    }  
}
