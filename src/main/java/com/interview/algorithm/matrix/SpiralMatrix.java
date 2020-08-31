/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.interview.algorithm.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhigui.cbw
 * @version $Id: SpiralMatrix.java, v 0.1 2020-07-29 17:44 zhigui.cbw Exp $$
 */
public class SpiralMatrix {

    private static List<Integer> getMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = matrix.length, col = matrix[0].length;
        //存放结果
        List<Integer> result = new ArrayList(row * col);
        // 其实列和结束列
        int startCol = 0, endCol = col - 1;
        // 其实行和结束行
        int startRow = 0, endRow = row - 1;
        while (startCol <= endCol && startRow <= endRow) {
            // 1. 遍历startRow行的各列数据，从左到右，遍历结束，对startRow+1,表示该行数据已经遍历过
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = startCol; i <= endCol; i++) {
                    result.add(matrix[startRow][i]);
                }
                ++startRow;
            }
            // 2. 遍历endCol列的各行数据，从上到下，遍历结束，对endCol-1,表示该列数据已经遍历过
            //    因为前一步遍历startRow行后，将要从当前行的最后一列所在列开始遍历
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = startRow; i <= endRow; i++) {
                    result.add(matrix[i][endCol]);
                }
                --endCol;
            }
            // 3. 遍历endRow行的各列数据，从右到左，遍历结束，对endRow-1,表示该行数据已经遍历过
            //    因为前一步遍历endCol列后，将要从当前列的最后一行所在行开始遍历
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
                --endRow;
            }
            // 4. 遍历startCol列的各行数据，从下到上，遍历结束，对startCol+1,表示该列数据已经遍历过
            //    同样，上一次之后，回到了行的最左侧，所以开始向上遍历该行所在的列
            if (startCol <= endCol && startRow <= endRow) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                ++startCol;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 创建一个数组
        // 1  2  3
        // 8  9  4
        // 7  6  5
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<Integer> result = getMatrix(matrix);
        if (!result.isEmpty()) {
            // 结果应是: 1 2 3 4 5 6 7 8 9
            for (Integer i : result) {
                System.out.print(i + " ");
            }
        }

    }
}
