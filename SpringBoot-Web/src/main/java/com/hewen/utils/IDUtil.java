package com.hewen.utils;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * ClassName IDUtil
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/4/22 10:51
 */
public class IDUtil {
    public static void main(String[] args) {
        System.out.println(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
//        return StringUtils.replace(UUID.randomUUID().toString(),"-","");
    }


}
