package com.yujin.demo.generics;

/**
 * 过界<T extends HasF>声明T必须具有类型HasF或者从HasF导出的类型。
 * @author yujin
 *
 * @param <T>
 */
public class ReturnGenericType<T extends HasF> {

    private T obj;
    public ReturnGenericType(T x) {
        this.obj = x;
    }
    
    public T get() {
        return obj;
    }
}

class HasF {}