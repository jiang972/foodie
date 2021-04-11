package com.jyx.algorithm;

public class linearSearch {

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

//        Student student4 = new Student("jyx");
//        Student[] stu = { new Student("www"),
//                          new Student("jyx"),
//                          new Student("xxx")};
        //Integer search2 = linearSearch.search(stu,student4);
        //System.out.println(search2);

        Integer n = 1000000;
        Integer[] orderData = ArrayGenerator.ArrayOrderGenerator(n);
        long startTime = System.nanoTime();
        Integer search3 = linearSearch.search(orderData,n-1);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000000.0;
        System.out.println(search3);
        System.out.println(duration);
    }
}
