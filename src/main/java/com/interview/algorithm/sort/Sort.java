package com.interview.algorithm.sort;

/**
 * @author cbw
 */
public class Sort {
    public static void main(String[] args) {
        int length = 100;
        int[] arr1 = new int[length];
        for (int i = 0; i < length; i++)
            arr1[i] = (int) (Math.random() * 1000);
        int[] arr = new int[arr1.length];
        for (int i = 0, j = arr1.length - 1; i < arr1.length && j >= 0; i++, j--) {
            arr[j] = arr1[i];
        }
        Sort sort = new Sort();
        QuickSort quickSort = new QuickSort();
        HeapSort heapSort = new HeapSort();
        ShellSort shellSort = new ShellSort();
        MergeSort mergeSort = new MergeSort();
        CountSort countSort = new CountSort();
        BucketSort bucketSort = new BucketSort();
        RadixSort radixSort = new RadixSort();

//        sort.bubbleSort(arr);
//        sort.selectSort(arr);
//        sort.insertSort(arr);
//        quickSort.sort(arr);
//        heapSort.heapSort(arr);
        shellSort.sort(arr);
//        mergeSort.sort(arr);
//        countSort.sort(arr);
//        bucketSort.sort(arr);
//        radixSort.radixSort(arr);


    }

    /*
     * @description 冒泡排序 时间复杂度：O(n^2)
     * 冒泡排序：一次循环后，最小的数上浮到数组首位，剩下的序列继续比较，循环结束即完成排序
     * 思路：相邻两个数相比较并交换，把最小的数冒泡到顶端
     * 从最后一位数开始和前一位数比较，如果比前一位小则两者交换，比较完成较小的数前移。
     * 。再将它与它的前一位比较，比较完后较小的数继续前移，所有位置比较一次后，数组首位为最小的数。
     * 接下来将第二位到最后一位的数组序列进行一次上述过程，完成后第二位为这个序列最小数。
     * 整个循环结束后完成排序
     * */
    public void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        System.out.println("冒泡排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        // printArr(arr);

    }

    /*
     * @description 选择排序 时间复杂度：O(n^2)
     * 思路：选取一个数，与剩下的数相比较并交换，选择出最小的数
     * 从第一位开始，第一位与剩下的序列中的数依次比较，若序列中的数小则直接交换。一次排序后得到最小的数并放在首位。
     * 接着从第二位开始，重复上述过程，排序后得到最小的数放在第二位。整个循环结束排序完成。
     * 与冒泡相似，每次排序得到最小的数并放在最前面的位置。但减少了比较的次数（首位与其他位分别比较交换）
     * */
    public void selectSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("选择排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    /*
     * @description 插入排序 时间复杂度：O(n^2)
     */
    public void insertSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= arr.length - 1; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                //arr[j-1]=temp;//temp表示需要插入的当前位置那个数，
                //temp位置之前的数均已排序完成，现只需要考虑将temp插入那个位置
                // 所以temp从当前位置开始依次与前面的数比较，只要该位置的数大，该数后移；直到该位置数小时，则将temp插入该位置的后一个位置
                j--;
            }
            arr[j] = temp;
        }
        System.out.println("插入排序完成，用时：" + (System.currentTimeMillis() - start) + "ms");
        printArr(arr);
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
