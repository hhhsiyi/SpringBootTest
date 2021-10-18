package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/10
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 第一个错误的版本278题 {
    @Test
    public void test01() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int tar = 12;
        //largestNumber(a);
        //System.out.println(search(a, tar));
        //System.out.println(99 / 100);
    }
    boolean isBadVersion(int version){
        return true;
    };
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }
}
