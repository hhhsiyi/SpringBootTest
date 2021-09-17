package com.hewen.mybatis09;

import com.hewen.mybatis09.mapper.UserMapper;
import com.hewen.mybatis09.pojo.User;
import com.hewen.mybatis09.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 2021/9/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(1);
        User user2 = userMapper.queryUserById(1);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user==user2);//如果不刷新缓存，对象就是同一个
        sqlSession.clearCache();
        user = userMapper.queryUserById(1);
        System.out.println(user==user2);//如果不刷新缓存，对象就是同一个
    }
}
