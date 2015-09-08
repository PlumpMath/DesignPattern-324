package com.yujin.sxt.proxy;

public class Client2 {

    public static void main(String[] args) {
        Tank t = new Tank();
        Moveable moveable = (Moveable)Proxy.newProxyInstance(Moveable.class);
        moveable.move();
    }
}
