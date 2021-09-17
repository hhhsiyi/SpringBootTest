package com.hewen.mybatis08.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * 2021/9/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//@SuppressWarnings("all")
public class IDUtils {
    @Test
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
