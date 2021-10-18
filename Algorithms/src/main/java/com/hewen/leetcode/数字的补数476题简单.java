package com.hewen.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2021/10/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 数字的补数476题简单 {
    @Test
    public void test01() {
//        String bin = getBin(1);
//        System.out.println(bin);
//        int hex = getHex(bin);
//        System.out.println(hex);
        int complement = findComplement(20161211);
        System.out.println(complement);
    }


    public int findComplement(int num) {
        String bin = getBin(num);
        int hex = getHex(bin);
        return hex;
    }

    public String getBin(int num) {
        int s = 0;
        int y = 0;
        String res = "";
        Stack<Integer> bin = new Stack<>();
        while (true) {
            s = num / 2;
            y = num % 2;
            bin.push(y);
            if (s < 1) {
                break;
            }
            num = s;
        }
        while (!bin.empty()) {
            res += String.valueOf(bin.pop());
        }
        res = res.replace('1', '-');
        res = res.replace("0", "1");
        res = res.replace("-", "0");
        return res;
    }

    public int getHex(String ss) {
//        Integer integer = Integer.valueOf(ss);
        Double aDouble = Double.valueOf(ss);
        //System.out.println(integer);
        double y = 0;
        int s = 0;
        double i = 0;
        double res = 0;
        while (true) {
            y = aDouble % 10;
            s = (int)(aDouble / 10);
            double v = (y) * Math.pow(2, i);
            i++;
            res += v;
            if (s < 1) {
                break;
            }
            aDouble = Double.valueOf(s);

        }
        //System.out.println((int)res);
        return (int)res;
    }
}
