package com.yujin.sxt.proxy;

public class TankLogProxy implements Moveable{

    Moveable tank;

    public TankLogProxy(Moveable tank) {
        super();
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("tank start ...");
        tank.move();
        System.out.println("tank stop ...");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        
    }

}
