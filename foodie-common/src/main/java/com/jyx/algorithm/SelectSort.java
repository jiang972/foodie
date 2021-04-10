package com.jyx.algorithm;


import io.swagger.models.auth.In;

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
    public static Integer[] selectSort(Integer[] data){
        if (data.length == 0)return data;
        for (int i = 0; i<data.length; i++){
            Integer min = i;
            for (int j = i+1; j<data.length; j++){
               if (data[j] < data[min]) min = j;
            }
            Integer middle = data[i];
            data[i] = data[min];
            data[min] = middle;
        }
        return data;
    }

    public static void main(String[] args) {
        Integer[] data = {2,3,5,78,3,5,1,2};
        Integer[] integers = selectSort(data);
        System.out.println(integers.toString());
    }
}
