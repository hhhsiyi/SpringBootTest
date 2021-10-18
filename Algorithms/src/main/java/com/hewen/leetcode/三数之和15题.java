package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/10/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 三数之和15题 {
    @Test
    public void test1() {
        int N = 4;
//        int[] a = SortTestHelper.generateRandomArray1(N, -10, 10);
//        int[] a={-1,0,1,-1,2,4};
        int[]a={0,0,0};
        for (int i :
                a) {
            System.out.print(i + " ");
        }
        ;
        System.out.println();
        threeSum(a);
    }

    //三重循环，二三重其实是并列的，可以通过双指针的方式来解决！
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> endLists = new ArrayList<>();
        if (nums.length < 3) {
            new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i :
                nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 因为去重会导致之后的值难算。淦
//        HashSet<Integer> integers = new HashSet<>();
//        for (int i :
//                nums) {
//            integers.add(i);
//        }
//        TreeSet<Integer> treeSet = new TreeSet<>(integers);
//        int[] ints = new int[integers.size()];
//        int t=0;
//        for (int i :
//                treeSet) {
//            System.out.print(i+" ");
//            ints[t] = i;
//            t++;
//        }
//        int size = integers.size()/2;
//        System.out.println();
//        System.out.println(size);
//        System.out.println("数组大小"+ints.length);
        // 以上部分只是在排序
        // 1.首位>0则跳过；
        // 2.本次=上次则跳过；
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if ((i > 0) && (nums[i] == nums[i - 1])) {
                continue;
            }
            //接下来就开始双指针
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];//当前值
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    endLists.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
//                    if (nums[left-1]==nums[left]){
//                        left++;
//                    }
//                    if (nums[right+1]==nums[right]){
//                        right--;
//                    }
                    while (left<right&&nums[left-1]==nums[left]){
                        left++;
                    }
                    while (left<right&&nums[right+1]==nums[right]){
                        right--;
                    }

                }else if (nums[left] + nums[right] > target){
                    right--;
                }
                else if (nums[left] + nums[right] < target){
                    left++;
                }
            }
        }
        System.out.println(endLists);
        return endLists;
    }
}
