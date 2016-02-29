package com.yujin.demo;

public class Employer implements Observerable {

    public long serial;
    public String name;
    public int age;
    private Observer mObserver;
    private Boss boss;
    public Employer(Observer observer, Boss boss) {
        this.mObserver = observer;
        this.boss = boss;
    }
    
    public void doWorking() {
        mObserver.notificate(boss);
    }
    
    public void doneWork() {
        mObserver.notificate(boss);
    }

    @Override
    public void update(Observerable observe) {
        // TODO Auto-generated method stub
        System.out.println("Employer update");
    }
}
