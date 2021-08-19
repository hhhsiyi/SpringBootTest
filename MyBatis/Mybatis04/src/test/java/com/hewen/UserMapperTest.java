package com.hewen;

import com.hewen.mapper.UserMapper;
import com.hewen.pojo.User1;
import com.hewen.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//这里测试属性名和数据库字段名不一致的情况
public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);//因为可能在多个场景使用，因此提升作用域

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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            List<User> userList = userDao.getUserList();//
            List<User1> user1List = userMapper.getUserList1();//使用别名就查不出来

            //方法2：全限定名再强转
            //List<User> userList = sqlSession.selectList("com.hewen.com.hewen.dao.UserDao.getUserList");
            //getMapper相当于去找dao的实现，
            //因为dao和mapperxml绑定了所以就有了联系
            //本来应该去拿实现的，但是面向接口编程
            //底层是动态代理，只要点class必反射
            for (User1 user1 : user1List) {
                System.out.println(user1);
            }
            //System.out.println(user1List);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() {
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }
    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startPage",1);
        map.put("pageSize",3);
        List<User1> user = mapper.getUserListByLimit(map);
        for (User1 user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
    @Test
    public void test4() {
        //getRowBounds 通过java代码层面实现
        RowBounds rowBounds = new RowBounds(1, 2);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<User1> objects = sqlSession.selectList("com.hewen.mapper.UserMapper.getUserListByRowBounds");
        for (User1 object : objects) {
            System.out.println(object);
        }
        List<User1> objects2 = sqlSession.selectList("com.hewen.mapper.UserMapper.getUserListByRowBounds",null,rowBounds);
        for (User1 object : objects2) {
            System.out.println(object);
        }
        sqlSession.close();
    }
}