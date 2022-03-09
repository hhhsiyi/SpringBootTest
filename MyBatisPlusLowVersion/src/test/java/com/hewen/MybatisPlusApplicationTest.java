package com.hewen;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hewen.mapper.UserMapper;
import com.hewen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 2022/3/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSimpleSelect() {
        //查询全部用户；
        //参数是一个wapper(条件构造器)
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
//        User user = new User(123L,"何文", 20, "19980928", "127.0.0.1");
        User user = new User();
        user.setPwd("19980928");
//        user.setId(123332L);
        user.setAge(12);
        user.setName("何文无id");
        userMapper.insert(user);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
//        User user = new User(123L,"何文", 20, "19980928", "127.0.0.1");
        User user = new User();
        user.setPwd("我没钱1222");
        user.setId(5L);
        user.setAge(212);
        user.setName("何文无id");
        userMapper.updateById(user);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testOptimisticLocker() {
//        乐观锁
//        User user = new User(123L,"何文", 20, "19980928", "127.0.0.1");
//        User user = new User();
//        user.setPwd("我没钱1222");
//        user.setId(3L);
//        user.setAge(212);
//        user.setName("何文无id");
        User user = userMapper.selectById(3L);
        Integer version = user.getVersion();
        System.out.println(version);
        user.setAge(23);
        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLocker2() {
//        乐观锁

        User user = userMapper.selectById(3L);
        Integer version = user.getVersion();
        System.out.println(version);
        user.setAge(23);
        //线程1
        //模拟另外一个线程执行插队操作，2来了，2更新了，
        User user2 = userMapper.selectById(3L);
        Integer version2 = user.getVersion();
        System.out.println(version2);
        user2.setAge(26);
        userMapper.updateById(user2);
//        此处可以用自旋锁来解决更新死锁问题
        userMapper.updateById(user);//如果没有乐观锁，更新就会丢失
    }

    @Test
    public void testQuery() {
        //批量查询
        User user = userMapper.selectById(1L);
        System.out.println(user);
        List<User> list = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        list.forEach(System.out::println);
    }

    @Test
    public void testQuery2() {
        //条件查询--使用map，后续会用wapper这个构造器
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "何文");
        //再加条件年龄20
        map.put("age", 20);
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        //测试分页查询
        Page<User> page = new Page<>(1, 5);
        //参数1，当前页，参数2，页面大小
        //使用了分页插件之后，所有的分页操作也都变得简单了起来
//        Page<User> list = userMapper.selectPage(page, null);
        userMapper.selectPage(page, null);
//        list.getRecords().forEach(System.out::println);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
        //这个事情告诉我们，他们在查询之前，先进行了一次count操作，这个在数据多的时候可能会造成查询时间变长。
    }

    @Test
    public void testDelete() {
        //测试删除
        userMapper.deleteById(1501090244080984065L);
//        User user = new User();
//        user.setId(1501090244080984065L);
//        userMapper.deleteById(user);
        //一个是传序列化的id，一个是传T 泛型
        userMapper.deleteBatchIds(Arrays.asList(1L, 2L, 3L));
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","何文无id");
        userMapper.deleteByMap(map);
    }


    @Test
    public void testLogicDelete() {
        //测试删逻辑除
        userMapper.deleteById(1501090244080984065L);
//        User user = new User();
//        user.setId(1501090244080984065L);
//        userMapper.deleteById(user);

    }
}
