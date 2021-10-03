package com.hewen.itemProcessorDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String perDesc;
    private Date createTime;
    private Date updateTime;
    private String sex;
    private Float score;
    private Double price;
}
