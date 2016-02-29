package com.yujin.demo.adapter;

public class Wrapper implements Targetable{

    private Source mSource;
    
    public Wrapper(Source source) {
        mSource = source;
    }
    
    @Override
    public void method1() {
        mSource.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

}
