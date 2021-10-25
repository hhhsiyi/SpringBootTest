package com.hewen.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2021/10/21
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 全排列46题中等 {
    @Test
    public void test01(){
        int[] ints = new int[]{1,2,3};
        List<List<Integer>> permute = permute(ints);
        System.out.println(permute.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        //回溯算法的时间复杂度是阶乘级别的，很耗时和空间！O(n*n!)
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len==0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean []used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return  res;
    }
    public void dfs(int[]nums, int len,int depth, Deque<Integer> path,boolean[] used,List<List<Integer>> res){
        if (len==depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i])
                continue;
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast();
            used[i]=false;
        }
    }
}
