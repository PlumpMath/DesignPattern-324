package com.yujin.sxt.proxy;

/**
 * 聚合方式
 * @author yujin
 *
 */
public class Tank3 implements Moveable {

    Tank tank;

    public Tank3(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        
    }
}
