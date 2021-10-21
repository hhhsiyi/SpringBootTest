package com.hewen.dao;

import com.hewen.pojo.User2;

import java.util.List;
import java.util.Map;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface UserDao {
    List<User2> getUserList();
    List<User2> getUserList2();
    List<User2> getUserLike(String value);

    User2 getUserById(int id);
    User2 getUserById2(Map<String,Object> user);
    int addUser(User2 user2);
    int addUser2(Map<String,Object> user);
    int updateUser(User2 user2);

    int deleteUserById(int id);
}
