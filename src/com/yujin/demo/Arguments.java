package com.yujin.demo;
/**
 * 在看JavaScript的时候发现函数调用和声明对实参和形参的要求与其它语言大有不同，
 * 在JavaScript中函数的声明中的形参列表的参数类型和参数个数对函数调用时的实参列表所传入的参数没关系。
 * 
 * 我就联想到了java中可不可以实现类似的功能呢？
 * 
 * @author yujin
 *
 */
public class Arguments {
    
    static AnimalInfo info = null;
    public static void main(String[] args) {
        AnimalCat animal = new AnimalCat();
        //info = animal.getAnimalInfo(null);
        info = animal.getAnimalInfo(new AnimalInfo() {

            @Override
            public String getInfo() {
                // TODO Auto-generated method stub
                System.out.println("通过实参传入的值");
                return "通过实参传入的值";
            }
            
        });
        info.getInfo();
    }
}

class AnimalCat {
    
    public AnimalInfo getAnimalInfo(AnimalInfo info) {
        if (info == null) {
            info = new AnimalInfo() {
                
                @Override
                public String getInfo() {
                    // TODO Auto-generated method stub
                    System.out.println("传入的实参为空");
                    return "传入的实参为空";
                }
            };
        }
        //System.out.println(info.getInfo());
        return info;
    }
}

interface AnimalInfo {
    public String getInfo();
}
