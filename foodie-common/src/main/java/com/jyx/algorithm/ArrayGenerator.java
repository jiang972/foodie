package com.jyx.algorithm;

public class ArrayGenerator {

    public static Integer[] ArrayOrderGenerator(Integer n){
        Integer[] num = new Integer[n];
        for (int i = 0; i < n;i++)
            num[i] = i;
        return num;
    }
}
