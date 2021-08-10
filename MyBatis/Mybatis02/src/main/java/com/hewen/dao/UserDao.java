package com.hewen.dao;

import com.hewen.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface UserDao {
    List<User> getUserList();
    List<User> getUserList2();
    List<User> getUserLike(String value);

    User getUserById(int id);
    User getUserById2(Map<String,Object> user);
    int addUser(User user);
    int addUser2(Map<String,Object> user);
    int updateUser(User user);

    int deleteUserById(int id);
}
