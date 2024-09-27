package com.mycompany.app.models;

public class Student {
    private String name;
    private int id;
    private float gpa;
    private String sex;

    public Student(){}

    public Student(String name, int id, float gpa, String sex){
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
}
