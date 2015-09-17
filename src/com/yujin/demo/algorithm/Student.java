package com.yujin.demo.algorithm;

import com.sun.org.apache.bcel.internal.generic.CASTORE;

public class Student implements Compareable{

    public int id;
    public String name;
    public int score;

    public Student() {

    }

    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            if (this.id > stu.id) {
                return 1;
            } else if (this.id == stu.id) {
                return 0;
            } else if (this.id < stu.id) {
                return -1;
            }
        }
        new ClassCastException().printStackTrace();
        return -100;
    }
    
    @Override
    public String toString() {
        return id + " ";
    }
}
