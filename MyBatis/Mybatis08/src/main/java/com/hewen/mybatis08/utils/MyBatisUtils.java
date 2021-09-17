package com.hewen.mybatis08.utils;

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
//SqlSessionFactoryBuilder这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。
    //SqlSessionFactory一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。最简单的就是使用单例模式或者静态单例模式。
    //SqlSession每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。 绝对不能将 SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。 也绝不能将 SqlSession 实例的引用放在任何类型的托管作用域中
    // 换句话说，每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应后，就关闭它。
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
        //这里可以传一个true设置为自动提交事务。挺好的。
    }

}
