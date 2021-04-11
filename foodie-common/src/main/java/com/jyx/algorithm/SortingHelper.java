package com.jyx.algorithm;

public class SortingHelper {


    public static <E extends Comparable<E>>Boolean checkSort(E[] data){
        //这块是对比i和i+1，所以不需要遍历到最后一个数据，不然就下标出界了
        for (int i = 0; i< data.length-1; i++){
            if (data[i].compareTo(data[i+1]) > 0)return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName,E[] data){
        long startTime = System.nanoTime();

        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000000.0;
        if (!checkSort(data))
            throw new RuntimeException("sort fail");
        System.out.println(duration);
    }
}
