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
    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(2);
        System.out.println(user);
//        sqlSession.clearCache();
//        int i = userMapper.updateUser(new User(6, "hewen", "hewen"));
//        System.out.println(i);
        User user1 = userMapper.queryUserById(2);
        System.out.println(user1);
    }
    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
//        sqlSession.clearCache();
//        int i = userMapper.updateUser(new User(6, "hewen", "hewen"));
//        System.out.println(i);
        User user1 = userMapper2.queryUserById(2);
        System.out.println(user1);
        sqlSession2.close();
    }
    @Test
    public void test04(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = userMapper2.queryUserById(2);
        System.out.println(user1);
        User user2 = userMapper2.queryUserById(1);
        System.out.println(user2);
        User user3 = userMapper2.queryUserById(1);
        System.out.println(user3);
        //最后肯定查了两遍数据库
        sqlSession2.close();
    }
}
