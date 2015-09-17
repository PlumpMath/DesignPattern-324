package com.yujin.sxt.proxy;

public class Client {

    public static void main(String[] args) {
        Tank t = new Tank();
        TankTimeProxy ttp = new TankTimeProxy(t);
        TankLogProxy tlp = new TankLogProxy(ttp);
        Moveable tank = tlp;
        tank.move();
    }
}
