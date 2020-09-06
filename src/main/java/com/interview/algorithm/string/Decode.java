package com.interview.algorithm.string;

/**
 * @author cbw
 */
import java.util.*;
public class Decode{
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        while(str.contains("]")) {
            int right = str.indexOf("]");
            int left = str.lastIndexOf("[",right);
            String tmp = str.substring(left+1,right); // 2|CA
            String[] splits = tmp.split("\\|");
            int n = Integer.parseInt(splits[0]);
            String str2 = "";
            for(int i = 0; i < n;i++) {
                str2 += splits[1];
            }
            str  = str.replace("[" + tmp + "]", str2);//HG[3|BCACA]F]

        }
        System.out.println(str);
    }
}
