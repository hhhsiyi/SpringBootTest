package com.hewen;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * ClassName IndexController
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/3 12:07
 */
@RestController
public class IndexController {
    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //高并发场景和非高并发场景的区别，如果锁提前过期了，其实也不是什么好事儿：
// 也就是业务操作时间大于锁的过期时间，锁被误删了！a线程加的锁，a锁过期了，b来了，b加了锁，a把b的锁给释放掉了，锁会乱序，也有可能永久失效。
// 问题分析：我自己加的锁被别的线程给释放掉了，怎么解决？
// 给每个线程的锁的value设置成为uuid或者别的什么
    @RequestMapping("/deduct_stock")
    public String deductStock() {
//        synchronized (this) {
        String lockKey = "要秒杀的产品product01";
        String clientId = UUID.randomUUID().toString();
        RLock redissonLock = redisson.getLock(lockKey);
        try {
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "1");
//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
            //设置过期时间
//            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);
            //setNx命令
            //redis线程模型是单线程，6是多线程了好像
            //如果执行过程中挂了，那key就永远留在redis里面了！
//            if (!result) {
//                return "error";
//            }//用了redission就又精简了部分代码，少写了一个watchDog监控进程
            String getStock = stringRedisTemplate.opsForValue().get("stock");
            if (null == getStock) {
                return "Stock为空";
            }

            redissonLock.lock(30,TimeUnit.SECONDS);//加一个watchDog类似的
            int stock = Integer.parseInt(getStock);
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存 " + realStock + "");
                return "扣减成功，剩余库存 " + realStock + "";
            } else {
                System.out.println("库存不足，扣减失败");
                return "库存不足，扣减失败";
//            }
            }
        } finally {
            redissonLock.unlock();
            //新加：判断这个锁是不是自己这个线程加的
//            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
//                //釋放鎖
//                stringRedisTemplate.delete(lockKey);
//            }
        }
        //搞个watchDog，如果没用完继续续期
        //redis的主从集群架构又得考虑别的问题，假如主里刚写好，主节点挂了，选了新的主节点出来，新的主节点里面就没有这个线程加的锁了
        //zookeeper内部的选举会保证数据的一致性，如果要求强一致性，我们可以选用zookeeper
        //redis的性能更牛逼
    }
}
