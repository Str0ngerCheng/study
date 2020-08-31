package com.interview.algorithm.sort;

/**
 * @author cbw
 */
public class ShellSort {
    /*
     * @description 当n在某个范围内时，时间复杂度可以达到O(n^1.3)
     * 优化的插入排序，当待排序列为基本有序时（小的在前，大的在后），简单插入排序的效率较高，（5，4，3，2，1）这种情况效率会很低
     * 希尔排序的思想是将序列按照一定的间隔（增量）进行分组，对每个分组内的序列分别进行插入排序，然后缩小增量，重复上述操作，直到增量为1；
     * 这样策略使得序列在初始阶段就达到了宏观上的基本有序，当增量为1时，不需要对序列做太大的调整（数据移动）就能完成插入排序
     * */
    private void sortOnce(int[] arr, int dist) {
        for (int i = dist; i < arr.length; i++) {
            int j=i;
            int temp = arr[i];
            while (j >= dist && temp < arr[j - dist]) {
                arr[j] = arr[j - dist];
                j -= dist;
            }
            arr[j] = temp;
        }

    }

    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        int dist = arr.length / 2;
        for (int i = dist; i >= 1; i /= 2)
            sortOnce(arr, i);
        System.out.println("希尔排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
