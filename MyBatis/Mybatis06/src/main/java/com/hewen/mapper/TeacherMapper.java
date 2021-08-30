package com.hewen.mapper;

import com.hewen.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 2021/8/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface TeacherMapper {
    @Select("select * from teacher where id = #{Tid}")
    Teacher getTeacher(@Param("Tid") int id);
}
