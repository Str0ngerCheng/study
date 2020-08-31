package com.interview.algorithm.sort;

/**
 * @author cbw
 */
public class HeapSort {

    /*
     * @description 堆排序 时间复杂度：O(nlogn)
     */

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 23, 4, 2, 5, 4, 6, 1, 10, 59, 100, 8695, 2145498, 54, 4, 7};
        new HeapSort().getTopK(a, 5);
    }

    private void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && arr[i] < arr[i + 1])
                i++;
            if (temp < arr[i]) {
                arr[start] = arr[i];
                start = i;
            } else break;
            //目的，保证调整后的堆，任何一个父节点的值都大于其子节点的值，所以较小的值会下沉到叶子节点
            //最后只需要比较根节点和左右子节点的大小就可以选出最大顶，同时也需要让较小值沉到叶子节点

        }
        arr[start] = temp;

    }

    public void heapSort(int[] arr) {
        long start = System.currentTimeMillis();
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--)
            heapAdjust(arr, i, size - 1);
        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i - 1);//
        }

        System.out.println("堆排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);

    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    //TOP K问题
    public void getTopK(int[] arr, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = arr[i];
        }
        for (int i = k / 2 - 1; i >= 0; i--)//以前k个元素 构造一个大顶堆top
            heapAdjust(top, i, k - 1);

        for (int i = k; i < arr.length; i++) {//arr后面的元素与大顶堆堆顶比较 若比堆顶小 则堆顶变为该元素 然后重新构造大顶堆
            //当所有元素都比大顶堆堆顶元素大时  该大顶堆中的元素即为最小的K个元素
            if (arr[i] < top[0]) {
                top[0] = arr[i];
                heapAdjust(top, 0, k - 1);
            }

        }

        for (int i = 0; i < k; i++)
            System.out.println(top[i] + " ");
    }


}
