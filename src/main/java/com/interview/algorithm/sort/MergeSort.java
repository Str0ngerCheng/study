package com.interview.algorithm.sort;

/**
 * @author cbw
 */
public class MergeSort {

    /*
     * @description 归并排序 时间复杂度：O(nlogn)
     */

    private void mSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mSort(arr, left, mid);
            mSort(arr, mid + 1, right);
            merge(arr, left, right);
        }

    }

    private void merge(int[] arr, int left, int right) {
        int[] temp=new int[arr.length];
        int mid = (right + left) / 2;
        int i = left;
        int j = mid + 1;
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {//i,j分别指向需要归并的两个数组的首位，从首位开始比较两个数组元素的大小，小的填充到temp中
            //相应的指针后移，再比较i,j所指向的元素大小，直到i或j到达末尾
            if (arr[i] < arr[j])
                temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        //将数组剩下的元素填充进temp，根据归并策略，数组两两合并，四四合并，因此归并前的两个数组内部都是有序的
        while (i <= mid)
            temp[t++] = arr[i++];
        while (j <= right)
            temp[t++] = arr[j++];

        //将归并后的数组填充到arr的相应位置
        for (int p = 0; p < t; p++) {//t 指需要归并的两个数组的总长度
            arr[left++] = temp[p];//如需要归并 45 67 这两个数组（序号代表索引） 此时arr[]应该从4开始填充 所以是left++
        }

    }

    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        int[] temp = new int[arr.length];
        mSort(arr, 0, arr.length - 1);
        System.out.println("归并排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
