package com.hewen.redis;

import redis.clients.jedis.Jedis;

/**
 * 2022/1/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestPing {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("localhost", 6379);
        //这个对象就是redis所有的命令
        System.out.println(jedis.ping());
    }
}
