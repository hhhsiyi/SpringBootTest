package com.hewen.mybatis09.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2021/9/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private int id;
    private String name;
    private String pwd;
}
