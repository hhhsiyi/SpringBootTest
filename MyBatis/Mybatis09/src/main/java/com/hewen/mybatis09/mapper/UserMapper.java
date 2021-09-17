package com.hewen.mybatis09.mapper;

import com.hewen.mybatis09.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 2021/9/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
