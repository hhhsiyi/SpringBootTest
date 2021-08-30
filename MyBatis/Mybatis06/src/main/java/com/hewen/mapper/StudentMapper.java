package com.hewen.mapper;

import com.hewen.pojo.Student;

import java.util.List;

/**
 * 2021/8/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface StudentMapper {
    //查询所有学生和老师的信息
    public List<Student>getStudent();
}
