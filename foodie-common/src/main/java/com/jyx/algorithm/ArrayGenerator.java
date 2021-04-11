package com.jyx.algorithm;

import java.util.Random;

public class ArrayGenerator {

    public static Integer[] ArrayOrderGenerator(Integer n){
        Integer[] num = new Integer[n];
        for (int i = 0; i < n;i++)
            num[i] = i;
        return num;
    }

    public static Integer[] GenerateRandomArray(int n,int bound){
        Integer[] num = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            num[i] = random.nextInt(bound);
        return num;
    }
}
