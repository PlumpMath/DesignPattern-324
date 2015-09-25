package com.yujin.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MyArrayList implements List {
    
    Object[] data;
    transient int size = 0;
    
    public static void main(String[] args) {
        System.out.println(null == null);
    }
    
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0 ? true : false;
    }


    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size];
        System.arraycopy(data, 0, obj, 0, size);
        return obj; //两种写法,也就是调用两个不同接口实现
        //return Arrays.copyOf(data, size);
    }


    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean add(Object e) {
        /*e可能为null,java允许null加入数组*/
        data[size++] = e;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }  
        remove(index);
        return true;
    }

    @Override
    public Object remove(int index) {
        Object obj = data[index];
        for (int i = index; i <= size - 2; i++) {
            data[i] = data[i+1];
        }
        data[--size] = null;
        return obj;
    }
    
    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }


    @Override
    public Object get(int index) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object set(int index, Object element) {

        return null;
    }


    @Override
    public void add(int index, Object element) {
        expendList();
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            /*考虑元素为空的情况
             * null == null ---> true
             * null != null ---> false
             * 有这种可能,就是传入的要定位的元素为null,就是要查找null在这个数组中的哪个位置,
             * 下面的例子null在数组中的第四个位置
             * 例如数组: 3,2,7,null,8,4,5.....
             * 
             * */
            if (data[i] == null || (data[i] != null && data[i].equals(o))) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private void expendList() {
        if (size == data.length) {
            int len = (data.length +1)/2 + data.length;
            Object[] temp = new Object[len];
            System.arraycopy(data, 0, temp, 0, len);
            data = temp;
        }
    }
    
    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
}
