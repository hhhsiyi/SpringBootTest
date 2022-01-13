package com.hewen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hewen.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 2022/1/13
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootTest
public class RedisSpringBootApplicationTests {
    @Autowired
//    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads(){
        //opsForValue操作字符串\opsForList操作list\opsForset\opsForHash操作字符串\opsForgeo\zset操作字符串
        //我们常用的操作，方法都可以通过redisTemplate进行操作、包括事务和基本的crud
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushAll();
//        connection.close();
        redisTemplate.opsForValue().set("mykey","我是傻逼！！！");
        String mykey = (String)redisTemplate.opsForValue().get("mykey");
        System.out.println(mykey);
    }
    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般都使用json来传递对象
        User hewen = new User("何文！", 13);
        String s = new ObjectMapper().writeValueAsString(hewen);
        redisTemplate.opsForValue().set("user",hewen);
        //可以传String，但是默认不能传对象，对象得序列化才行
        //org.springframework.data.redis.serializer.SerializationException:
        // Cannot serialize; nested exception is org.springframework.core.serializer.support.SerializationFailedException:
        // Failed to serialize object using DefaultSerializer;
        // nested exception is java.lang.IllegalArgumentException:
        // DefaultSerializer requires a Serializable payload but received an object of type [com.hewen.pojo.User]
        //implements Serializable
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
