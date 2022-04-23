package com.hewen.spring;

/**
 * ClassName BeanDefinition
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/28 9:17
 */
public class BeanDefinition {
    //定义的bean
    private Class type;
    private String scope;
    //是否懒加载

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
