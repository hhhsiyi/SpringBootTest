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

    private Integer sb;

    private int s2b;
    
    private String name;
    
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sb=" + sb +
                ", s2b=" + s2b +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSb() {
        return sb;
    }

    public void setSb(Integer sb) {
        this.sb = sb;
    }

    public int getS2b() {
        return s2b;
    }

    public void setS2b(int s2b) {
        this.s2b = s2b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
    }

    public Student(Integer id, Integer sb, int s2b, String name, Teacher teacher) {
        this.id = id;
        this.sb = sb;
        this.s2b = s2b;
        this.name = name;
        this.teacher = teacher;
    }
}