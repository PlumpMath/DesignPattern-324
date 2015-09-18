package com.yujin.demo;

public class Observer {

    public void notificate(Observerable observerable) {
        System.out.println("---观察者收到通告---");
        if (observerable instanceof Boss) {
            System.out.println("收到发给Boss通知");
        }
        if (observerable instanceof Employer) {
            System.out.println("收到发给Employer的通知");
        }
        observerable.update(observerable);
    }
}
