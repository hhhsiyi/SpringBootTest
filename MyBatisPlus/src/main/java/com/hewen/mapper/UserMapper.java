package com.hewen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hewen.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 2022/3/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//在对应mapper上继承基本的接口BaseMapper
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //所有的curd操作已经完成了。！。！
    //不需要写一大堆配置文件了
}
