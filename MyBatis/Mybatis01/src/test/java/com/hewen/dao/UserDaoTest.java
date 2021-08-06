package com.hewen.dao;

import com.hewen.pojo.User;
import com.hewen.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //获得SqlSession对象
        //执行SQL
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //getMapper相当于去找dao的实现，
        //因为dao和mapperxml绑定了所以就有了联系
        //本来应该去拿实现的，但是面向接口编程
        //底层是动态代理，只要点class必反射
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println(userList);
        sqlSession.close();
        //BindingException绑定异常
        //静态资源过滤
//        sqlSession.selectOne("select 1 from dual");
//        System.out.println((String) sqlSession.selectOne("select 1 from dual"));
    }
}
