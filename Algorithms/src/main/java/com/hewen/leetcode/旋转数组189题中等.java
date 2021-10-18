package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 旋转数组189题中等 {
    //TODO 没做完
    @Test
    public void test01() {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums, 5);
//        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
//        int index = Math.abs(nums.length - k);
        int index = k>nums.length?nums.length-k%nums.length:nums.length-k;
        int[] ints = new int[nums.length];
        int i = 0;
        //      System.out.println(nums[index]);
        while (i != nums.length) {
            if (index % nums.length==0)
                index = 0;
            ints[i] = nums[index];
            index++;
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = ints[j];
        }
    }
}
