/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.interview.algorithm;

import java.util.List;

/**
 * @author zhigui.cbw
 * @version $Id: Test.java, v 0.1 2020-07-28 16:42 zhigui.cbw Exp $$
 */
public class Test {
    //数组移动0
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    //有序数组二分查找
    public static boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else
                return true;
        }
        return false;
    }

    //有序数组合并
    public static int[] mergeArr(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (i <= arr1.length - 1 && j <= arr2.length - 1) {
            if (arr1[i] < arr2[j])
                result[k++] = arr1[i++];
            else
                result[k++] = arr2[j++];
        }
        if (i <= arr1.length - 1)
            result[k++] = arr1[i++];
        if (j <= arr2.length - 1)
            result[k++] = arr2[j++];

        return result;

    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }

    }

    //最长公共子序列
    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public static int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) /* 符号判定 */
                continue;
            if (c < '0' || c > '9') /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');

        }
        return isNegative ? -ret : ret;

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int max_length = 0;
        for (String temp : wordDict) {
            max_length = temp.length() > max_length ? temp.length() : max_length;

        }
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && max_length >= i - j; j--) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    //字符串1到j-1位可以被拆分，且wordDict包含字符串第j到i-1位
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }


    private void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for(int i=2*start+1;i<=end;i=2*i+1){
            if(i<end&&arr[i]<arr[i+1]){
                i++;
            }
            if(temp<arr[i]) {
                arr[start] = arr[i];
                start = i;
            }else break;
        }
        arr[start]=temp;


    }
    public static void main(String[] args) {
        /*int[] arr = {0,2,3,0,4,50,0,0,9,6,0};
        moveZeroes(arr);
        printArr(arr);*/
        int[] arr1 = { 1, 3, 5, 7, 103 };
        int[] arr2 = { 2, 2, 6, 6, 8, 9, 10 };
        printArr(mergeArr(arr1, arr2));
        System.out.println(StrToInt("-100"));

    }
}
