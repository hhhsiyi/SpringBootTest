package com.hewen.dao;

import com.hewen.pojo.User;
import com.hewen.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */

public class UserDaoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //BindingException绑定异常
        //静态资源过滤
//        sqlSession.selectOne("select 1 from dual");
//        System.out.println((String) sqlSession.selectOne("select 1 from dual"));
        try {//获得SqlSession对象
            //执行SQL
            //方法1：getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            //方法2：全限定名再强转
            //List<User> userList = sqlSession.selectList("com.hewen.com.hewen.dao.UserDao.getUserList");
            //getMapper相当于去找dao的实现，
            //因为dao和mapperxml绑定了所以就有了联系
            //本来应该去拿实现的，但是面向接口编程
            //底层是动态代理，只要点class必反射
            for (User user : userList) {
                System.out.println(user);
            }
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User userList = userDao.getUserById(1);
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int userList = userDao.addUser(new User(5, "格纹", "19980928"));
        if (userList > 0) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
        //搞完发现没变化，需要注意，增删改需要提交事务的，不然就相当于白做了
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int userList = userDao.updateUser(new User(1, "真何文", "19980928"));
        if (userList > 0) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
        //搞完发现没变化，需要注意，增删改需要提交事务的，不然就相当于白做了
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int userList = userDao.deleteUserById(5);
        if (userList > 0) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
        //搞完发现没变化，需要注意，增删改需要提交事务的，不然就相当于白做了
    }
    @Test
    public void test6() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId",6);
        userMap.put("userName","ewe");
        userMap.put("userPwd","1998");
        int userList = userDao.addUser2(userMap);
        if (userList > 0) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
    }
    @Test
    public void test7() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("helloId",1);
        userMap.put("pwd",1);//如果不在xml里判空，那是查不出来值的
        User userList = userDao.getUserById2(userMap);
        if (userList !=null) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
        //搞完发现没变化，需要注意，增删改需要提交事务的，不然就相当于白做了
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserLike("h");//这种情况有点low啊
        if (userList !=null) {
            System.out.println(userList);
            sqlSession.commit();
        }
        sqlSession.close();
        //搞完发现没变化，需要注意，增删改需要提交事务的，不然就相当于白做了
    }
}