package com.jyx.algorithm;

public class Student {
    private String name;

    Student(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Student stu = (Student)obj;
        return this.name.equals(stu.name);
    }

}
