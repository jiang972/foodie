package com.jyx.algorithm;

public class Student  implements Comparable<Student>{
    private String name;
    private Integer score;

    Student(String name,Integer score){
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Student o) {
        if (this.score == o.score)
            return 0;
        else if (this.score < o.score)
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        return "name :" + name +" score :" + score;
    }
}
