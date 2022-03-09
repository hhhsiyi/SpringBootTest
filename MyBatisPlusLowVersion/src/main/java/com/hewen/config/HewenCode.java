package com.hewen.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * 2022/3/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class HewenCode {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        //配置策略
        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//项目目录
//        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setOutputDir("D:/code/springcloud/MyBatisPlusLowVersion"+"/src/main/java");
        gc.setAuthor("何文");
        gc.setOpen(false);//生成完是否需要打开文件夹
        gc.setFileOverride(true);//是否覆盖
        gc.setServiceName("%sService");//去掉service的I前缀
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis?userSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dsc.setUsername("root");
        dsc.setPassword("19980928");
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dsc);
        //3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.hewen");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        //4.策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user");//设置要映射的表名
        sc.setNaming(NamingStrategy.underline_to_camel);//驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setSuperEntityClass("");//你自己的父类实体，如果没有就不用设置
        sc.setEntityLombokModel(true);//自动lombok
        sc.setLogicDeleteFieldName("deleted");//逻辑删除
//        sc.setRestControllerStyle(true);
        //5.自动填充配置
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);
        TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(create_time);
        tableFills.add(update_time);
        sc.setTableFillList(tableFills);
        sc.setVersionFieldName("version");//乐观锁
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);//这个的作用是 //localhost:8080/hello_id_2;


        mpg.setStrategy(sc);

        //执行
        mpg.execute();
    }
}
