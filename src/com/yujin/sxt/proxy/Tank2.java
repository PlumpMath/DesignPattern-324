package com.yujin.sxt.proxy;

/**
 * 继承方式
 * @author yujin
 *
 */
public class Tank2 extends Tank {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("run time: " + (end - start));
        
    }

    
}
