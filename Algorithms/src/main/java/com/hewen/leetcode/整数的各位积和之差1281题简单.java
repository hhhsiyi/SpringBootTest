package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2022/2/16
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 整数的各位积和之差1281题简单 {
    public int subtractProductAndSum(int n) {
        String s = n + "";
        int sum = 0;
        int minu = 1;
        for (int i = 0; i <s.length(); i++) {
            Character c = s.charAt(i);
            sum+=Character.getNumericValue(c);
            minu*=Character.getNumericValue(c);
        }
        return minu-sum;
    }

    @Test
    public void test() {
        System.out.println(subtractProductAndSum(234));
    }
}
