package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2022/2/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 在区间范围内统计奇数数目1523简单 {
    @Test
    public void test01(){
        int low = 4;
        int high = 8;
        System.out.println(countOdds2(3,100000));
        System.out.println(countOdds(3,3));
    }

    public int countOdds(int low, int high) {
        int sum = 0;
        if (low%2!=0){
            sum++;
            low++;
        }
        if (high%2!=0){
            sum++;
            high--;
        }
        sum+= (high-low)/2;
        return sum;
    }
    public int countOdds2(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            if (i%2!=0){
                sum++;
            }
        }
//        if (low%2!=0){
//            sum++;
//        }
//        if (high%2!=0){
//            sum++;
//        }
//        sum+= (high-low-1)/2;
        return sum;
    }
}
