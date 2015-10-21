package com.yujin.demo.generics;
/**
 * 与其使用Object，我们更喜欢暂时不指定类型，而是稍后再决定具体使用什么类型。
 * 要达到这个目的，需要使用类型参数，用尖括号住，放在类名后面。然后在使用这个类的时候，再用实际的类型替换些参数。
 * 
 * 这就是Java泛型的核心概念：告诉编译器想使用什么类型，然后编译器帮你处理一切细节。
 * 
 * 一般而言，你可以认为泛型与其它的类型差不多，只不过它们碰巧有类型参数罢了，
 * 稍后我们会看到，在使用泛型时，我们只需要指定它们的名称以及类型参数表即可。
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
