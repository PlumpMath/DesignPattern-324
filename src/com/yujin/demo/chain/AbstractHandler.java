package com.yujin.demo.chain;

public abstract class AbstractHandler {

    public Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
