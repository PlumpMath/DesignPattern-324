package com.yujin.demo.properties;

import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

public class TestProperties {

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(TestProperties.class.getResourceAsStream("build.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Set set = prop.keySet();
        for (Object object : set) {
            System.out.println(object);
        }
        Collection collection = prop.values();
        Object[] object = collection.toArray();
        for(int i = 0; i < object.length; i++) {
            System.out.println(object[i]);
        }
    }
}
