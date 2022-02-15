package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/2/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 矩阵中的幸运数1380题简单 {
    @Test
    public void test01(){
//        {{3,7,8},{9,11,13},{15,16,17}};
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
//模拟
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        //行最小
        int[]row;
        for (int i = 0; i < m; i++) {
            int index = 0;
            for (int j = 0; j < n; j++) {
                //行里求最小的
                if (matrix[i][j]<matrix[i][index]){
                    index=j;
                }
            }
            int index2 = i;
            for (int j = 0; j < m; j++) {
                if (matrix[j][index]>matrix[i][index]){
                    index2=j;
                    break;
                }
            }
            if (index2==i){
                res.add(matrix[i][index]);
            }
        }
        //列最大
        int[]col;
        return res;
    }
}
