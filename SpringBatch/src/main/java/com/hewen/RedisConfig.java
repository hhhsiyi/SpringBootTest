package com.hewen;

import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021/7/27
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Accessors(chain = true)//链式写法
public class RedisConfig {
    //最简单的redis调用
    @Test
    public void test01(){
        Jedis jedis = new Jedis("localhost", 6379);
//        jedis.auth("我现在没有密码");//输密码
        //jedis.set("hewen","傻逼");
        String hewen = jedis.get("hewen");
        System.out.println(hewen);
    }
    @Test
    public void test02(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        HostAndPort node1 = new HostAndPort("localhost", 7001);
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(node1);
        JedisCluster jedisCluster = new JedisCluster(nodes, 100, 100, 100, "密码", jedisPoolConfig);
        jedisCluster.set("hewen","sssb");
        System.out.println(jedisCluster.get("hewen"));
    }
}
