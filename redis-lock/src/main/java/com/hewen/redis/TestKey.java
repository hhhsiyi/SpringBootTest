package com.hewen.redis;

import redis.clients.jedis.Jedis;

/**
 * 2022/1/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestKey {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("localhost", 6379);
        //这个对象就是redis所有的命令
        System.out.println("清空当前数据库" + jedis.flushDB());
        System.out.println("判断某个键值对是否存在" + jedis.exists("username"));
        System.out.println("新增" + jedis.set("username", "wanglu"));
        System.out.println("新增" + jedis.set("password", "llll"));
        System.out.println("当前所有键" + jedis.keys("*"));
        System.out.println("随机返回一个key: " + jedis.randomKey());
        System.out.println("删除" + jedis.del("password"));
        System.out.println("判断是否存在" + jedis.exists("password"));
        System.out.println("重命名key" + jedis.rename("username", "nowname"));
        System.out.println("取出改名后的key " + jedis.get("nowname"));
        System.out.println("按索引查询 " + jedis.select(0));


    }
}
