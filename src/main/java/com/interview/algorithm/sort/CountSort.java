package com.interview.algorithm.sort;

import java.util.Arrays;

/**
 * @author cbw
 */
public class CountSort {
    public static void main(String[] args) {

        System.out.println(986 / 10);
    }

    /*
     * @description 计数排序 时间复杂度：O(n)
     * 思想：通过空间换取时间。需要比较多的辅助空间，适合元素不大，元素个数较多的序列的排序
     * 新建一个数组，待排序列元素的大小就是该数组的下标，因此需要先获取待排序列的最大元素，已确定新建数组的大小。
     * 然后统计每个元素的个数，作为新建数组该下标对应的元素值（新建数组初始赋0值）
     * 最后按顺序输出新建数组，即可到有序序列。
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        int maxValue = max(arr);
        int[] count = new int[maxValue + 1];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++)
                arr[k++] = i;
        }
        System.out.println("计数排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);


    }

    private int max(int[] arr) {
        int maxVlue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVlue)
                maxVlue = arr[i];
        }
        return maxVlue;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
