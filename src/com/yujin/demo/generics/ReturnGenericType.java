package com.yujin.demo.generics;

/**
 * ����<T extends HasF>����T�����������HasF���ߴ�HasF���������͡�
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