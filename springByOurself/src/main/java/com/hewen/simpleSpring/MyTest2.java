package com.hewen.simpleSpring;

import com.hewen.simpleSpring.AppConfig2;
import com.hewen.simpleSpring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName Test
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/27 15:24
 */
public class MyTest2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        UserService userService = (UserService)context.getBean("userService");

//        UserService userService = (UserService) context.getBean("userService");//动态代理返回的不是实现而是接口,动态代理代理的是接口!,
//        UserInterface userService = (UserInterface) context.getBean("userService");
        userService.test();
    }
    /**
     * bean对象是由spring帮助我们创建出来的
     * UserService.class
     * ------->(推断构造方法,
     * 如果有1个构造方法,就默认调用这个构造方法;
     * 如果有多个构造方法,就会报错;
     * 除非在想用的构造方法上面加@AutoWired注解;
     * 如果没有构造方法,就走默认的无参构造方法了
     * 用哪个bean,先byType再byName)
     * ------->无参构造方法
     * ------->得到一个普普通通的UserService对象
     * ------->"依赖注入":但是此时并不是我们的bean对象,此时里面的orderService还是空的,我们继续注入了属性之后才可以使用,这个过程就叫依赖注入
     * ------->初始化前(PostConstruct)
     * ------->初始化(afterPropertiesSet)
     * ------->初始化后(AOP)
     * ------->得到一个代理对象
     * ------->单例池里的对象如果第一次没有,我们就进行创建,(这里有个问题,我们代理对象和原生对象应该放哪个进入池子里?如果产生了代理类,就把代理对象放进去,没产生的话就放原来的就行了)
     * ------->变成一个常规的Spring Bean对象.
     * 那这个事情到底是发生了什么呢?这里发生了依赖注入,代码如下.
     * 之后:单例池:
     * ConcurrentHashMap <beanName,bean对象>
     *
     */
    /**
     * UserService(OrderService orderService),如果要走这个构造函数,spring会先去单例池Map里面去找有没有叫orderService的bean对象,如果没有就会创建;
     * 这个过程中应该用orderService形参名字来找还是应该用OrderService类型去找呢,很明显应该用类型去找,最保险,但是我们可能有多个同类型的bean
     * 那我们找的顺序就是先byType后byName
     * component和bean注解都可以用来定义bean
     * 如果有就会用这个来创建,前提是OrderService也是一个bean对象.
     * 如果是多例bean的话,则直接进行创建,没有其他烦恼.
     * 但是!如果我们真的又去创建OrderService对象的时候,就又有可能出现循环依赖这个问题
     * OrderService依赖UserService,UserService依赖OrderService,就会循环依赖
     */
//                for (
//    Field declaredField : targetClass.getDeclaredFields()) {
//        if (declaredField.isAnnotationPresent(Autowired.class)) {
//            //证明这个字段的对象是要进行依赖的注入的
//            declaredField.setAccessible(true);
//            //我要把orderService注入,那我就默认认为你就是要拿orderService 作为你的对象,就去bean容器里去找名字叫orderService的这个东西.
//            //找出来之后赋值给这个属性.
//            //这个其实就是一个依赖注入的过程了
//            declaredField.set(o, getBean(declaredField.getName()));
//            //??代表什么呢?对于userService来说他就需要一个orderService对象,那如何得到orderService对象呢又?
//        }
//    }
}
