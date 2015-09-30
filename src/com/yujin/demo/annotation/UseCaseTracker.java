package com.yujin.demo.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (null != uc) {
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
