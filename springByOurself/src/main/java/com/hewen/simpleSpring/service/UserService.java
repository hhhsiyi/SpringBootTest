package com.hewen.simpleSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName UserService
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/31 15:58
 * @author Hewen
 */
@Component
public class UserService {
    @Autowired
    private OrderService orderService;

//    public UserService(OrderService orderService) {
//        this.orderService = orderService;
//        System.out.println("走有参构造");
//    }
    public void test(){
        System.out.println(orderService);
    }
}
