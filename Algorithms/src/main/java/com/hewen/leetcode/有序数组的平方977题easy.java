package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2021/10/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 有序数组的平方977题easy {
    @Test
    public void test01() {
        int[] nums = new int[]{-4, -1, 0, 2, 3, 5,6};
        int[] ints = sortedSquares2(nums);
        for (int num : ints) {
            System.out.println(num);
        }
    }

    //最粗鲁的方式，时间复杂度为nlogn，肯定不满足题目的要求，题目进阶为On复杂度
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    //双指针
    public int[] sortedSquares2(int[] nums) {
        int smallerZeroNums = 0;
        while (nums[smallerZeroNums] < 0) {
            smallerZeroNums++;
        }
        //将0定位出来
        System.out.println("=====" + smallerZeroNums + "=====");
        // num[z--]与num[i++]比大小
        int bigZeroNums = nums.length - smallerZeroNums;
        int[] res = new int[nums.length];
        int i = 0;
        int right = smallerZeroNums;
        int flg = -1;
        while (smallerZeroNums > 0 || right < nums.length) {
            if (smallerZeroNums<=0){
                //左边走完了
                res[i]=nums[right]*nums[right];
                right++;
                i++;
            }
            else if (right>=nums.length){
                res[i]=nums[smallerZeroNums]*nums[smallerZeroNums];
                smallerZeroNums--;
                i++;
            }
            else if (Math.abs(nums[smallerZeroNums - 1]) < nums[right]) {
                res[i] = nums[smallerZeroNums - 1] * nums[smallerZeroNums - 1];
                i++;
                smallerZeroNums--;
                flg = 1;
            } else {
                res[i] = nums[right] * nums[right];
                i++;
                right++;
                flg = 2;
            }
        }
//        while (i!=nums.length){
//            if (flg==1){
//                //
//            }
//            res[i]=nums[i]*nums[i];
//            i++;
//        }
//        if (flg == 1) {
//            while (i < nums.length) {
//                res[right]=nums[i]*nums[i];
//                i++;
//            }
//        }else {
//        }
        return res;
    }
}
