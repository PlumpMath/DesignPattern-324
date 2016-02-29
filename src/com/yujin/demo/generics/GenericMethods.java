package com.yujin.demo.generics;
/**
 * 我们看到的泛型，都是应用于整个类上，但同样可以在类中包含参数化方法，
 * 而这个方法所在的类可以是泛型类，也可以不是泛型 类。也就是说，是否拥有泛型方法，与其所在的类是否是泛型没有关系。
 * 
 * @author yujin
 *
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
        /**
         * 事实上，泛型方法与自动打包避免了许多以前我们不得不自己编写出来的代码。
         */
    }
}
/**
 * GenericMethods并不是参数化的，尽管这个类和其内部的方法可以被同时参数化，
 * 但是在这个例子中，只有方法f()拥有类型参数。这是由该方法的返回类型前面的类型参数列表指明的。
 */
