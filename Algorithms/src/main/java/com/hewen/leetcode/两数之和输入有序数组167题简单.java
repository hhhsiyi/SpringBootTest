package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/12
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 两数之和输入有序数组167题简单 {
    @Test
    public void test01() {
        int[] a = {0,0,3,4};
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
//        moveZeroes(a);
        int[] ints = twoSum(a, 0);
        for (int i :
                ints) {
            System.out.println(i);
        }

    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r;
        boolean flag = false;
        int[] ints = new int[2];
        for (; l < numbers.length; l++) {
            r = l+1;
//            if (numbers[l] >= target)
//                break;
            if (flag)
                break;
            ints[0]=l+1;
            while (r < numbers.length) {
//                if (numbers[l]==numbers[r]){
//                    r++;
//                    continue;
//                }
                if (numbers[r] == target - numbers[l]) {
                    ints[1] = r+1;
                    flag=true;
                    break;
                } else
                    r++;
            }
        }
        return ints;
    }

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

}
