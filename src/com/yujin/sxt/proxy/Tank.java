package com.yujin.sxt.proxy;

import java.util.Random;

public class Tank implements Moveable {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank moving ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
    }

    @Override
    public void stop() {
        
    }

}
