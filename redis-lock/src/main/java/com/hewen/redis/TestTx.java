package com.hewen.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 2022/1/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestTx {
    public static void main(String[] args) {
        //1.new jedis对象
        Jedis jedis = new Jedis("localhost", 6379);
        //这个对象就是redis所有的命令
        System.out.println(jedis.ping());
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("mylove","wl");
        Transaction multi = jedis.multi();
        //事务，开启事务
        String s = jsonObject.toJSONString();
        //jedis.watch(s);//乐观锁
        //ctrl+alt+t很方便的快捷键！！！！
        try {
            multi.set("user1",s);
            multi.set("user2",s);
            //这里模拟一下事务执行失败，不用的时候就注释掉就行了
//            int i = 0/1;
            multi.exec();//成功就执行事务
        } catch (Exception e) {
            multi.discard();//放弃事务
            e.printStackTrace();
        } finally {
            System.out.println("+"+jedis.get("user1"));
            System.out.println("+"+jedis.get("user2"));
            jedis.close();
        }
    }
}
