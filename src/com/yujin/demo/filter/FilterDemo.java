package com.yujin.demo.filter;

import java.util.Arrays;

/**
 * 在看JavaScript中发现JS的数组有一个filter方法
 * var data = [1, 2, 3, 4, 5]
 * var arr = data.filter(function(x){
 *      return x > 3;
 * });
 * 结果:[4, 5]
 * JS中filter()返回的数组元素是调用的数组的一个子集， 就是筛选出一个复合条件的子数组出来。
 * 我就在想Java的Array能不能有同样的方法呢？
 * 
 * @author yujin
 *
 */

class MyArray {
    Object[] value;
    
    public MyArray(Object[] obj) {
        this.value = obj;
    }
    
    public Object[] filter(Filter filter) {
        Object[] newObjects = {};
        if(filter == null) return null;
        for (int i = 0; i < value.length; i++) {
             if (filter.compare(value[i])) {
                 newObjects = Arrays.copyOf(newObjects, newObjects.length+1);
                 newObjects[newObjects.length - 1] = value[i];
             }
        }
        return newObjects;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T[] sort(Compareable<T> compareable) {
        T[] newT = (T[])new Object[value.length];
        System.arraycopy(value, 0, newT, 0, value.length);
        if (compareable == null) return null;
        for (int i = 0; i < value.length -1; i++) {
            for (int j = 0; j < i; j++) {
                newT = Arrays.copyOf(newT, newT.length + 1);
                if (compareable.compare(value[i], value[j])) {
                    Object temp = value[i];
                    value[i] = value[j];
                    value[j] = temp;
                }
            }
        }
        return newT;
    }
}

interface Filter {
    public boolean compare(Object elem);
}

interface Compareable<T> {
    public boolean compare(Object obj, Object obj2);
}

public class FilterDemo {

    public static void main(String[] args) {
        String[] str = {"zhangsan", "lisi", "wangmazi", "zhaowu", "likui"};
        MyArray arr = new MyArray(str);
        /*Object[] strr = arr.filter(new Filter() {

            @Override
            public boolean compare(Object elem) {
                // TODO Auto-generated method stub
                if (elem instanceof String) {
                    String e = (String)elem;
                    return e.contains("zh");
                }
                return false;
            }
            
        });*/
        
        Object[] strrs = arr.sort(new Compareable<Object>() {

            @Override
            public boolean compare(Object obj1, Object obj2) {
                // TODO Auto-generated method stub
                if (obj1 instanceof String && obj2 instanceof String) {
                    String e1 = (String)obj1;
                    String e2 = (String)obj2;
                    if (e1.toCharArray()[0] > e2.toCharArray()[0]) {
                        return true;
                    }
                }
                return false;
            }
            
        });
        for(int i = 0; i < strrs.length; i++) {
            System.out.print(strrs[i] + ",");
        }
    }
}