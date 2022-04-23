package com.hewen.spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ClassName Scope
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/28 9:15
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {
    String value() default "";
}
