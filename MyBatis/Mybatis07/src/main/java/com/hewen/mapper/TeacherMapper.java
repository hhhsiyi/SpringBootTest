package com.hewen.mapper;

import com.hewen.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2021/8/31
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface TeacherMapper {
    public Teacher getTeacher();
    public List<Teacher> getTeacher(@Param("tid")int id);
}
