package com.jyx.algorithm;

public class linearSearch<E> {

    private linearSearch(){};

    public static <E>Integer search(E[] data, E target){
        for(int i = 0 ;i<data.length;i++)
            if (data[i].equals(target))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {2,4,56,444,655,35,54};
        Integer search = linearSearch.search(data,655);
        System.out.println(search);

        Student student1 = new Student("www");
        Student student2 = new Student("jyx");
        Student student3 = new Student("xxx");
        Student student4 = new Student("jyx");
        Student[] stu = {student1,student2,student3};
        Integer search2 = linearSearch.search(stu,student4);
        System.out.println(search2);
    }
}
