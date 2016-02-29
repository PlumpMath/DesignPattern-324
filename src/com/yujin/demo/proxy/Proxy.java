package com.yujin.demo.proxy;

public class Proxy implements Sourceable{
    
    private Source mSource;
    
    public Proxy() {
        super();
        mSource = new Source();
    }
    
    @Override
    public void method() {
        before();
        mSource.method();
        after();
    }
    
    private void after() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    } 
}
