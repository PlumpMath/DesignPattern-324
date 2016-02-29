package com.yujin.demo;
/**
 * 演示接口声明中可以有方法声明和方法实现
 * 之前总以为接口中只可以有方法声明，不可以有方法实现
 * @author yujin
 *
 * @param <E>
 */
public interface IIterator<E> {

    public boolean hasNext();
    
    E remove(E e);
    
    default void contain(E e) {
        System.out.println("接口中可以有方法的实现");
    }
}
