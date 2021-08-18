package com.hewen;

import com.hewen.mapper.UserDao;
import com.hewen.pojo.User1;
import com.hewen.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//这里测试属性名和数据库字段名不一致的情况
public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);//因为可能在多个场景使用，因此提升作用域

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
//            List<User> userList = userDao.getUserList();//
            List<User1> user1List = userDao.getUserList1();//使用别名就查不出来

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


}