package com.hewen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2021-08-19 15:32:19
 */
@Data
@AllArgsConstructor
public class Teacher implements Serializable {
    private static final long serialVersionUID = 844248216314815322L;
    
    private Integer id;
    
    private String name;


}