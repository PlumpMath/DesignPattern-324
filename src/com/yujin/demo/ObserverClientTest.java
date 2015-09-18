package com.yujin.demo;

public class ObserverClientTest {

    public static void main(String[] args) {
        Observer observer = new Observer();
        Boss boss = new Boss(observer);
        Employer employer = new Employer(observer, boss);
        employer.doWorking();
        employer.doneWork();
    }
}
