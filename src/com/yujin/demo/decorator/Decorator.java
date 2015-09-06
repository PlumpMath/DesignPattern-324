package com.yujin.demo.decorator;

public class Decorator implements Sourceable {

    private Sourceable mSourceable;
    
    public Decorator(Sourceable source) {
        super();
        mSourceable = source;
    }
    
    @Override
    public void method() {
        System.out.println("before decorator!");
        mSourceable.method();
        System.out.println("after decorator!");  
    }

}
