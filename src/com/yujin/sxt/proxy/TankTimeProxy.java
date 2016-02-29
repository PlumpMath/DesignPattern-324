package com.yujin.sxt.proxy;

public class TankTimeProxy implements Moveable {

    Moveable tank;

    public TankTimeProxy(Moveable tank) {
        super();
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start time: " + start);
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
    }

    @Override
    public void stop() {
        long start = System.currentTimeMillis();
        System.out.println("start time: " + start);
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
    }

}
