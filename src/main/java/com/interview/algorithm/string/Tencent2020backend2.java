package com.interview.algorithm.string;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author cbw
 */
public class Tencent2020backend2 {

// 递减栈 栈中元素数目即为能看到的楼数目
// 两个栈 一个表示向左能看到的数目 一个表示向右 注意所有栈都不考虑当前所在楼本身 因此最后结果要加1
// 以向右看为例
// 单调栈里维护了从最左边到该位置前递减序列 而到达当前位置的递减序列对于当前位置来 都是可见的
// 因此单调栈的大小保存了能看到楼的个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0; i<n; i++) {
            height[i] = sc.nextInt();
        }

        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        ArrayList<Integer> count1 = new ArrayList();
        ArrayList<Integer> count2 = new ArrayList();

        for(int i = 0, j = height.length-1; i < height.length && j>=0; i++, j--) {
            count1.add(stack1.size());
            count2.add(0, stack2.size());
            while(!stack1.empty() && stack1.peek() <= height[i]) stack1.pop();
            while(!stack2.empty() && stack2.peek() <= height[j]) stack2.pop();
            stack1.push(height[i]);
            stack2.push(height[j]);
        }
        for(int i=0; i<n; i++) {
            System.out.print(count1.get(i) + count2.get(i) + 1 + " ");
        }
    }
}
