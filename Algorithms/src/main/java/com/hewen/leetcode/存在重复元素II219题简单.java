package com.hewen.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022/2/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 存在重复元素II219题简单 {
    @Test
    public void test() {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate2(nums, k));
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        if (nums.length == 1) {
            return res;
        }
        //Arrays.sort(nums);
        /*
        排序了之后，其实只需要比较前后两个值了
         */
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]==nums[i+1]){
//                if (nums[i]*2<=k){
//                    return true;
//                }
//            }
//        }
//        return res;
        int left = 0;
        int right = 1;
        while (left < nums.length) {
            for (right=left+1; right <nums.length; right++) {
                if (nums[left]==nums[right]){
                    if (Math.abs(right-left)<=k){
                        return true;
                    }
                }
            }
            left++;
        }
        return res;
    }
}
