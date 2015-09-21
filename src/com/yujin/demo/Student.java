package com.yujin.demo;

public class Student {

    public long id;
    public String name;
    public double Score;

    public Student() {

    }
    
    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (null == obj)
            return false;
        if (this == obj)
            return true;
        System.out.println(obj.getClass().getCanonicalName());
        System.out.println(obj.getClass().getName());
        obj.getClass().getTypeParameters();
        if (obj instanceof Student) {
            Student stu = (Student)obj;
            return this.id == stu.id;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[" + id + ":" + name + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

}
