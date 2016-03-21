package com.yujin.demo;
/**
 * 在看JavaScript语法的时候发现经常会遍历对象的属性和值，还要判断这个属性是自有属性还是继承来的属性，
 * 因为JS是弱类型，它可以动态添加和删除属性。
 * 我就在想Java能不能遍历对象的属性呢，遍历到这些属性和值， 摘取一些有用的属性和值动态的创建类，进而
 * 再new一个对象，这样可以达到像JavaScript一样的动态添加和删除属性的效果。
 * @author yujin
 *
 */
public class ForEachPrototype {

    public static void main(String[] args) {
        java.util.Calendar clndr = java.util.Calendar.getInstance();
        Class<?> cls = clndr.getClass();

        System.out.println(cls.getName());
        java.lang.reflect.Field[] flds = cls.getFields();
        
        if (flds != null) {
            for (int i = 0; i < flds.length; i++) {
                try {
                    System.out.println(flds[i].getName() + "=" + flds[i].get(clndr));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
