package com.hewen.service;

import com.hewen.spring.*;

/**
 * ClassName UserService
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/27 15:24
 */
//@Component("userService")
@Component
//@Scope("prototype")//多例
@Scope("singleton")//多例
public class UserService implements UserInterface,BeanNameAware , InitializingBean {
    @Autowired
    private OrderService orderService;

    @Override
    public void test(){
        System.out.println(orderService);
        System.out.println(admin);
    }

    private String beanName;

    private String xxx;

    private User admin; // 希望管理员的信息是从数据库中额外查出的.假如用Autowired,spring并无法完成查库的操作,所以引入了另一个后置构造方法

    @PostConstruct
    public void a(){
        //对admin进行塞值,从数据库查数据,并封装,这个可以用于加载初始化的数据这种用途.
        User user = new User();
        user.setId(01);
        user.setName("管理员");
        this.admin = user;
    }
    @Override
    public void setBeanName(String beanName) {
        //这个是Spring容器的方法,那spring在什么时候会回调这个方法呢?
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        //其实在这里可以写很多很多的代码,
        System.out.println("初始化完成后进行塞值");
//        throw new NullPointerException();
    }

    public User getAdmin() {
        return admin;
    }



}
