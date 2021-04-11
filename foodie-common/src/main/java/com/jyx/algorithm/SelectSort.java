package com.jyx.algorithm;


import io.swagger.models.auth.In;

import java.util.Arrays;

/**
 * 选择排序：（选择最小的排序）
 * 把最小的拿出来
 * 剩下的，再把最小的拿出来
 * 剩下的，再把最小的拿出来
 * 。。。。。以此类推
 *
 * 每次都找还没处理的部分中最小的元素
 */
public class SelectSort {

    /**
     * 默认一个最小值Integer.MIN_VALUE
     * 1.先把当前数组的最小值找到,然后更新这个最小值
     * 2.再遍历数组，找最小值
     * @param data
     * @return
     */
    public static <E extends Comparable<E>>void selectSort(E[] data){
        if (data.length == 0)return ;
        for (int i = 0; i<data.length; i++){
            Integer min = i;
            for (int j = i+1; j<data.length; j++){
               if (data[j].compareTo(data[min]) < 0)
                   min = j;
            }
            swap(data,i,min);
        }
        return ;
    }

    private static <E> void swap(E[] data ,int i,int j){
        E z = data[i];
        data[i] = data[j];
        data[j] = z;
    }
    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.GenerateRandomArray(10,100);
         selectSort(data);
        for (Integer i : data)
            System.out.println(i);
        System.out.println(SortingHelper.checkSort(data));

        Student[] stus = {  new Student("jyx",32),
                            new Student("sss",11),
                            new Student("sss",44),
                            new Student("sss",31)};
        selectSort(stus);
        for (Student student : stus)
            System.out.println(student.toString());
    }
}
