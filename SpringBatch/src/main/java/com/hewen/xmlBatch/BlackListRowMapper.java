package com.hewen.xmlBatch;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2021/8/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component
public class BlackListRowMapper implements RowMapper<BlackListEntity> {
    public BlackListEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BlackListEntity blackList = new BlackListEntity();
        blackList.setName(rs.getString("NAME"));
        return blackList;
    }

}
