package com.hewen.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2021/10/9
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 最大间距164题 {
    @Test
    public void test1() {
        int N = 4;
        //int[] a = SortTestHelper.generateRandomArray1(N, 0, 10);
        //int[]a = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        int[]a = {4,51,520};
        Arrays.sort(a);
        for (int i : a
        ) {
            System.out.print(i+"  ");
        }
        System.out.println("\n数组排序");
        System.out.println(maximumGap2(a));
    }

    public int maximumGap(int[] nums) {
        if (nums.length<2)
            return 0;
        //Arrays.sort(nums);
        Set<Integer> ints = new HashSet<>();
        for (int i : nums) {
            ints.add(i);
        }
        TreeSet<Integer> treeSet = new TreeSet<>(ints);
        int maxGap = 0;
        int left;
        Object[] objects = treeSet.toArray();
        left=(int)objects[0];
        for (int i : treeSet) {
            if (i-left>0&&i-left>maxGap){
                maxGap=i-left;
            }
            left=i;
        }
        return maxGap;
    }
    //题解基数排序，淦，看不懂的一道题解
    public int maximumGap2(int[] nums) {
        if (nums.length<2)
            return 0;
        int[]buf = new int[nums.length];
        long exp = 1;
        int maxGap = Arrays.stream(nums).max().getAsInt();//获取数组中的最大值

        while (maxGap>=exp){
            int[]cnt = new int[10];//基数0-9
            for (int i = 0; i < nums.length; i++) {
                int dight = (nums[i] / (int) exp) % 10;
                cnt[dight]++;//相当于
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, nums.length);
            exp *= 10;

        }
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
