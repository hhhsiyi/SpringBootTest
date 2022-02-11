package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2022/2/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 学生分数的最小差值1984题简单 {
    @Test
    public void test(){
        int[] nums = {87063,61094,44530,21297,95857,93551,9918};
        int k = 6;
        System.out.println(minimumDifference(nums,k));
    }
//[87063,61094,44530,21297,95857,93551,9918]
//6
    public int minimumDifference(int[] nums, int k) {
        if (k<2){
            return 0;
        }
        Arrays.sort(nums);
        //滑动窗口！！！
        int differ = Integer.MAX_VALUE;
        for (int i = nums.length-1; i >=k-1 ; --i) {
            if (nums[i]-nums[i-k+1]<differ){
                differ = Math.min(differ,nums[i]-nums[i-k+1]);
            }
        }
        return differ;
    }
}
