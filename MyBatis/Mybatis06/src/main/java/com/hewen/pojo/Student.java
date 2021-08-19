package com.hewen.pojo;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-08-19 15:31:24
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 845748626562553899L;
    
    private Integer id;
    
    private String name;
    
    private Integer tid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

}