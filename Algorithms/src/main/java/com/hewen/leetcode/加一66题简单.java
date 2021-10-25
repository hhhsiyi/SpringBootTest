package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 加一66题简单 {
    @Test
    public void test01() {
        int[] a = {9};
        int[] ints = plusOne(a);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
                if (i - 1 < 0) {
                    int[] ints = new int[digits.length + 1];
                    ints[0] = 1;
                    return ints;
                }
                if (digits[i - 1] != 9) {
                    digits[i - 1] += 1;
                    return digits;
                }
            }
        }
        return digits;
    }
}
