package com.hewen.mapper;


import com.hewen.pojo.User1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface UserMapper {
    @Select("select *from user08")
    List<User1> getUsers();
    //规范是基本类型就加Param，引用类型就不用加
    //说白了，方法存在多个参数，所有的参数前面必须加@param注解
    @Select("select *from user08 where id = #{id}")
    User1 getUserById(@Param("id") int id);
    @Select("select *from user08 where id = #{id}")
    User1 getUserById3(User1 user1);
    @Select("select *from user08 where id = #{id} and name = #{name}")
    User1 getUserById2(@Param("id")int id,@Param("name")String name);
    @Insert("insert into user08(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User1 user1);
    @Update("update user08 set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User1 user1);
    @Update("delete from user08 where id=#{uid}")
    int deleteUser(@Param("uid") int id);
//    List<User1> getUserListByLimit(Map<String ,Integer> map);
//    List<User1> getUserListByRowBounds();
//    List<User1> getUserList();
//    List<User1> getUserList1();
//    //List<User1> getUserList2();
//    List<User1> getUserLike(String value);
//
//    User1 getUserById(int id);
//    User1 getUserById2(Map<String,Object> user);
//    int addUser(User1 user1);
//    int addUser2(Map<String,Object> user);
//    int updateUser(User1 user1);
//
//    int deleteUserById(int id);
}
