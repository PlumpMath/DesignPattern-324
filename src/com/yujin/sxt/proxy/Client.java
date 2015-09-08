package com.yujin.sxt.proxy;

public class Client {

    public static void main(String[] args) {
        Tank t = new Tank();
        TankLogProxy tlp = new TankLogProxy(t);
        TankTimeProxy ttp = new TankTimeProxy(tlp);
        Moveable tank = ttp;
        tank.move();
    }
}
