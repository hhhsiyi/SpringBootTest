package com.hewen.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    //实体类
    private Long deptno;//主键
    private String dname;
    private String db_source;
    //数据存在哪个数据库的字段

    public Dept(String dname) {
        this.dname = dname;
    }
    /*
    * 如果不加
    * */
}
