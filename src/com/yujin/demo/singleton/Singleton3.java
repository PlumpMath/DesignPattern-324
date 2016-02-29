package com.yujin.demo.singleton;

public class Singleton3 {

	private Singleton3() {
		
	}
	
	private static class SingletonFactoy {
		private static Singleton3 instance = new Singleton3();
	}
	
	public Singleton3 getInstance() {
		return SingletonFactoy.instance;
	}
}
