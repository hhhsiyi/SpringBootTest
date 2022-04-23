package com.hewen.service;

import com.hewen.spring.BeanPostProcessor;
import com.hewen.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName HewenPostProcessor
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/29 11:24
 */
@Component
public class HewenPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if (beanName.equals("userService")){
            //单独去处理某个bean,或者批量去处理
            System.out.println("初始化前");
            System.out.println("当前这个bean的名字为userService");
        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)){
            //如果是userService,我们就返回这个类的代理类
            Object o = Proxy.newProxyInstance(HewenPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("这里是切面逻辑");
                    //先执行切面的逻辑,再在返回的时候执行这个方法本来要执行的方法.
                    return method.invoke(bean,args);//执行原有对象的方法
                }
            });
            return o;
            //Exception in thread "main" java.lang.ClassCastException: class com.sun.proxy.$Proxy5 cannot be cast to class com.hewen.service.UserService (com.sun.proxy.$Proxy5 and com.hewen.service.UserService are in unnamed module of loader 'app')
            //	at com.hewen.MyTest.main(MyTest.java:28)
            //这里报错,是因为,jdk的动态代理返回的不是实现而是接口.
        }
        return bean;
    }
}
