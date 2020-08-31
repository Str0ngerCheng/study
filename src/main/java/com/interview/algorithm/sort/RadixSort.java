package com.interview.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cbw
 */
public class RadixSort {
    public static void main(String[] args) {
    }

    public void radixSort(int[] arr) {
        if (arr == null && arr.length == 0)
            return;
        int maxBit = getMaxBit(arr);

        for (int i = 1; i <= maxBit; i++) {
            List<List<Integer>> buf = distribute(arr, i); //分配
            collecte(arr, buf); //收集
        }
        printArr(arr);


    }

    /**
     * 分配
     *
     * @param arr  待分配数组
     * @param iBit 要分配第几位
     * @return
     */
    public List<List<Integer>> distribute(int[] arr, int iBit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for (int j = 0; j < 10; j++) {//桶类型为0~9
            buf.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            buf.get(getNBit(arr[i], iBit)).add(arr[i]);
        }
        return buf;
    }

    //获取一个数的位数以及一个数的某一位：可以转字符串再做截取，或者直接用除10和模10

    /**
     * 收集
     *
     * @param arr 把分配的数据收集到arr中
     * @param buf
     */
    public void collecte(int[] arr, List<List<Integer>> buf) {
        int k = 0;
        for (List<Integer> bucket : buf) {
            for (int ele : bucket) {
                arr[k++] = ele;
            }
        }

    }

    /**
     * 获取最大位数
     *
     * @param arr
     * @return
     */
    public int getMaxBit(int[] arr) {
        int max = 0;
        for (int ele : arr) {
            //int len = (ele+"").length();
            int len = getBit(ele);
            if (len > max)
                max = len;
        }
        return max;
    }

    /**
     * 获取x的第n位，如果没有则为0.
     *
     * @param x
     * @param n
     * @return
     */
    public int getNBit(int x, int n) {

        //String sx = x + "";
        //if(sx.length() < n)
        if (getBit(x) < n)
            return 0;
        else
            // return sx.charAt(sx.length()-n) - '0';
            return (x / (100 * (n))) % 10;//字符转整数
    }

    public int getBit(int x) {
        int count = 1;
        while (x / 10 > 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }

}