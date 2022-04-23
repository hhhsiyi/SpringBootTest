package com.hewen.simpleSpring;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName AppConfig
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/27 15:28
 */
@ComponentScan("com.hewen.simpleSpring.service")
@EnableAspectJAutoProxy
public class AppConfig2 {
}
