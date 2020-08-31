/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.interview.algorithm.回溯;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhigui.cbw
 * @version $Id: ZimuCombination.java, v 0.1 2020-08-31 16:38 zhigui.cbw Exp $$
 */
public class ZimuCombination {
    private Map<String, Integer> combinations = new HashMap();
    private int num=0;

    public static void main(String[] args) {
        System.out.println(new ZimuCombination().getNum("baca"));
    }
    public void letterCombinations() {

        Character[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y'};
        backtrack( str, 0, new StringBuffer());
    }

    public void backtrack( Character[] str, int index, StringBuffer combination) {
        if (index == 4) {
            combinations.put(combination.toString(), num);
            num++;
        } else {
            for (int i = 0; i < 25; i++) {
                combination.append(str[i]);
                if (index < 3) {
                    combinations.put(combination.toString(), num);
                    num++;
                }
                backtrack(str, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public int getNum(String combination) {
        if (combinations.size() == 0) {
            letterCombinations();
        }
        return combinations.get(combination);

    }
}
