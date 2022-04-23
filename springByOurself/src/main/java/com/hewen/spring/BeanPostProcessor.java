package com.hewen.spring;

/**
 * ClassName BeanPostProcessor
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/29 11:23
 */
public interface BeanPostProcessor {
    //这个接口存在的意义就是:
    //允许我们程序员以更加灵活的方式去处理和操作bean对象.
    public Object postProcessBeforeInitialization(String beanName,Object bean);

    public Object postProcessAfterInitialization(String beanName,Object bean);
}
