package com.hewen.itemProcessorDemo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class PersonRowMapper implements RowMapper<Person> {

    /**
     * rs一条结果集，rowNum代表当前行
     */
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getInt("id")
                ,rs.getString("name")
                ,rs.getString("per_desc")
                ,rs.getDate("create_time")
                ,rs.getDate("update_time")
                ,rs.getString("sex")
                ,rs.getFloat("score")
                ,rs.getDouble("price"));
    }

}