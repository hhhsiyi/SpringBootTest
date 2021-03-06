package com.hewen.mapper;

import com.hewen.pojo.User1;

import java.util.List;
import java.util.Map;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface UserDao {
    List<User1> getUserList();
    List<User1> getUserList1();
    List<User1> getUserList2();
    List<User1> getUserLike(String value);

    User1 getUserById(int id);
    User1 getUserById2(Map<String,Object> user);
    int addUser(User1 user1);
    int addUser2(Map<String,Object> user);
    int updateUser(User1 user1);

    int deleteUserById(int id);
}
