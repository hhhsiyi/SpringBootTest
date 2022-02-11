package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2022/2/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 长度最小的子数组209题中等 {
    //滑动窗口
    @Test
    public void test() {
        int target = 213;
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
//        Arrays.sort(nums);
        int availableLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right<nums.length){
            int sum = 0;
            int temp = left;
            while (temp<=right){
                sum+=nums[temp];
                temp++;
            }
            if (sum>=target){
                availableLen=Math.min(availableLen,right-left+1);
                left++;
                continue;
            }
            right++;
        }
        return availableLen==Integer.MAX_VALUE?0:availableLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
