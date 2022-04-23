package com.hewen.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName Autowired
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/28 17:58
 * @author Hewen
 */
@Target({ElementType.FIELD})//加在属性上
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

}
