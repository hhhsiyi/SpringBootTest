package com.hewen.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyBatisUtils {
    //SqlSessionFactory->SqlSession
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //1.获取SqlSessionFactory对象
            String resource = "MyConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//静态代码块，加载的时候就有

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
