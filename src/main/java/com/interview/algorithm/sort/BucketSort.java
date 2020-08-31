package com.interview.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cbw
 */
public class
BucketSort {

    private void bucketSort(int[] arr, int bucketSize) {
        int minValue = arr[0], maxValue = arr[0];
        final int Defuat_BucketSize = 10;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) minValue = arr[i];
            else if (arr[i] > maxValue) maxValue = arr[i];
        }
        System.out.println(minValue + " " + maxValue);
        if (bucketSize <= 0) bucketSize = Defuat_BucketSize;
        int bucketNum = ((maxValue - minValue) / bucketSize) + 1;//因为数组下标从0开始，所以桶数量需要加1，
        // 以保证能够存储序列中最大的数
        List<List<Integer>> buketList = new ArrayList<List<Integer>>();
        for (int i = 0; i < bucketNum; i++)
            buketList.add(new LinkedList<Integer>());
        for (int i = 0; i < arr.length; i++) {
            buketList.get((arr[i] - minValue) / bucketSize).add(arr[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            if (buketList.get(i) != null)
                Collections.sort(buketList.get(i));
        }

        int k = 0;
        for (List<Integer> temp : buketList) {
            for (int i = 0; i < temp.size(); i++)
                arr[k++] = temp.get(i);
        }


    }

    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        bucketSort(arr, 10);
        System.out.println("桶排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
