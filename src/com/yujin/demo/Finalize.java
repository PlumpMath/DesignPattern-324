package com.yujin.demo;

/**
 * 演示Object对象的finalize方法调用时机
 * 
 * think in java 中提到GC时，那是不是只要显式的调用了 System.GC() 就会触发 finalize呢？
 * GC是相当有智商和情商的，所以调用gc后只是告诉GC系统去回收内存，具体怎么做，回不加收都由智能的GC系统说了算。
 * 所以gc方法作用不是很大，就算不调用gc方法，系统也会定时的进行垃圾回收的，调了也只是告诉一声该去回收了。
 * 
 * @author yujin
 *
 */
public class Finalize {
    
    public static void main(String[] args) {
        Finalize fin = new Finalize();
        //fin = null;  /*不写这句时调用gc，finalize方法不会被调用*/
        System.gc();
    }
    
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("finalize方法被调用!");
    }
    
    
}
