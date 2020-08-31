package com.interview.algorithm.sort;

/**
 * @author cbw
 */
public class QuickSort {

    /*
     * @description 快速排序 时间复杂度：O(nlogn)
     */

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 23, 4, 2, 5, 4, 6};
        new QuickSort().getTopK(a, 7);


    }

    //对于递归算法，递归过深可能会导致线程的栈空间不足.递归属于方法调用，会大量创建栈帧，当递归过深，栈帧无法出栈导致栈空间不足
    private int partition(int[] arr, int left, int right) {

        int baseValue = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= baseValue) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }//小数移动到左边
            while (left < right && arr[left] <= baseValue) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];//大数移动到右边
                right--;
            }
        }
        arr[left] = baseValue;
        return left;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int base = partition(arr, left, right);
        quickSort(arr, left, base - 1);
        quickSort(arr, base + 1, right);

    }

    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快速排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /*
     * Top K问题
     * */
    public void getTopK(int[] arr, int k) {
        if (arr != null && arr.length > 0) {
            int low = 0;
            int high = arr.length - 1;
            int index = partition(arr, low, high);
            //不断调整分治的位置，直到position = k-1
            while (index != k - 1) {
                //大了，往前调整
                if (index > k - 1) {
                    high = index - 1;
                    index = partition(arr, low, high);
                }
                //小了，往后调整
                if (index < k - 1) {
                    low = index + 1;
                    index = partition(arr, low, high);
                }
            }
        }
        for (int i = 0; i < k; i++)
            System.out.println(arr[i] + " ");
    }

}
