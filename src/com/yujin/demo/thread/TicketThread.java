package com.yujin.demo.thread;

class MyThread extends Thread {
    public int ticketCount = 5;
    public String name;
    
    public MyThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        while (ticketCount > 0) {
            ticketCount--;
            System.out.println(name + "卖出了1张票"+ "剩余票数为" + ticketCount);
        }
    }
    
}

/**
 * 场景:火车站卖票,现在火车站还剩5张票,由三个窗口来卖.
 * @author yujin
 *
 */
public class TicketThread {

    public static void main(String[] args) {
        MyThread mth1 = new MyThread("窗口1");
        MyThread mth2 = new MyThread("窗口2");
        MyThread mth3 = new MyThread("窗口3");
        mth1.start();
        mth2.start();
        mth3.start();
    }
}
