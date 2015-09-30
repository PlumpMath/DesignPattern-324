package com.yujin.demo.thread;

class MyThread2 implements Runnable {
    public int ticketCount = 5;//一共有五张火车票
    @Override
    public void run() {
        while (ticketCount > 0) {
            ticketCount--;// 一个窗口卖出一张票数就减一
            System.out.println(Thread.currentThread().getName()
                    + "卖出了1张票,剩余票数为:" + ticketCount);
        }
    }
}

public class TicketRunnable {

    public static void main(String[] args) {
        MyThread2 mth = new MyThread2();
        Thread th1 = new Thread(mth, "窗口1");
        Thread th2 = new Thread(mth, "窗口2");
        Thread th3 = new Thread(mth, "窗口3");
        th1.start();
        th2.start();
        th3.start();
    }
}
