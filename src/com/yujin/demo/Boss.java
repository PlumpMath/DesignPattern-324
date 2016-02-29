package com.yujin.demo;

public class Boss implements Observerable {

    public String name;
    public int age;
    private Observer mObserver;
    
    public Boss(Observer observer) {
        this.mObserver = observer;
    }
    
    public void payOff() {
        System.out.println("发工资");
    }

    @Override
    public void update(Observerable observe) {
        // TODO Auto-generated method stub
        System.out.println("Boss update");
        payOff();
    }
}
