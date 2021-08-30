package com.hewen.xmlBatch;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * 2021/8/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Startup {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:xmlBatch/applicationContext.xml");
        DataSource datasource = (DataSource)context.getBean("dataSourceNew");
        Logger logger = Logger.getRootLogger();
        System.out.println(datasource.toString());
        BlackListLoader blackListLoaderTask = (BlackListLoader) context.getBean("blackListLoader");
        blackListLoaderTask.loadBlackList();
        //从定义的bean中拿出来一个实例，然后就进行调用方法执行job

    }
}
