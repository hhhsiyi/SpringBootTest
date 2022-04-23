package com.hewen.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName HewenApplicationContext
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/3/27 15:26
 */
public class HewenApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public HewenApplicationContext(Class configClass) {
        this.configClass = configClass;
//        构造方法里到底应该干什么
//        1.至少要去扫描包
        //1.扫描bean->创建beanDefinition->存入beanDefinitionMap中去
        if (configClass.isAnnotationPresent(ComponentSacn.class)) {
            Annotation annotation = configClass.getAnnotation(ComponentSacn.class);
            //判断是否有这个注解
            ComponentSacn annotation2 = (ComponentSacn) configClass.getAnnotation(ComponentSacn.class);
            //如果有,我就去拿到这个注解
            String componentPath = annotation2.value();//此时拿到的这个值,就是我们要的扫描路径
            //com.hewen.service
            componentPath = componentPath.replace('.', '/');
            /**
             * 虽然我们拿到了这个目录,但是我们真正应该扫描的是target目录下的class文件.
             */
            //去拿ClassLoader
            ClassLoader classLoader = HewenApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(componentPath);//此时拿到的url,其实就是我们的target目录下的service文件夹
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    System.out.println(fileName);

                    if (fileName.endsWith(".class")) {
                        //后缀是class的文件
                        /**
                         * 又有问题了,我们现在拿到了类,但是我们需要确认我们这个类是不是一个spring Bean,怎么算是呢,判断有没有component注解;
                         * 如何判断是否有注解呢,必须有class对象,就得利用反射.
                         * 正好可以利用前面的类加载器.
                         */
                        //加载类的时候应该用全限定名,例如com.hewen.service.UserService,我们需要把fileName进行一次转换
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));//全限定名
                        className = className.replace("\\", ".");
                        className.replace("\\", ".");
                        System.out.println("全限定名为" + className);
                        Class<?> aClass = null;
                        try {
                            aClass = classLoader.loadClass(className);
                            if (aClass.isAnnotationPresent(Component.class)) {
                                if (BeanPostProcessor.class.isAssignableFrom(aClass)) {
                                    //这个类是不是实现了这个接口.
                                    BeanPostProcessor o = (BeanPostProcessor) aClass.newInstance();
                                    beanPostProcessorList.add(o);
                                }
                                //判断这个类上面有没有这个注解,
                                //执行到这个地步,就说明这是一个我们写出来的SpringBean了!
                                //在spring里,他不是先生成bean对象,而是生成bean
                                String beanName = aClass.getAnnotation(Component.class).value();
                                //todo 没有对beanName为空进行判断!
                                //接下来就要对beanName为空进行判断
                                if ("".equals(beanName)) {
                                    beanName = Introspector.decapitalize(aClass.getSimpleName());//对类名进行首字母小写的转换
                                }
                                BeanDefinition beanDefinition = new BeanDefinition();
                                if (aClass.isAnnotationPresent(Scope.class)) {
                                    beanDefinition.setScope(aClass.getAnnotation(Scope.class).value());
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinition.setType(aClass);
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
//                System.out.println(resource);
            }
        }
        //2.实例化单例bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                //单例
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
                //创建出来的单例bean全部存到
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        Class targetClass = beanDefinition.getType();
        //对应的类
        //要创建的类必须药有无参构造
        try {
            /**
             * Q?Spring Bean的生命周期?
             * 1.实例化bean对象
             * 2.进行依赖注入!
             */
            Object o = targetClass.getConstructor().newInstance();
            //在创建的过程中,返回之前就给对象里面的属性去赋值,
            //这里就是在模拟bean的生命周期
            //我们不需要给所有的属性都赋值,只需要给那些加了autowired注解的属性去赋值
            for (Field declaredField : targetClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    //证明这个字段的对象是要进行依赖的注入的
                    declaredField.setAccessible(true);
                    //我要把orderService注入,那我就默认认为你就是要拿orderService 作为你的对象,就去bean容器里去找名字叫orderService的这个东西.
                    //找出来之后赋值给这个属性.
                    //这个其实就是一个依赖注入的过程了
                    //todo 所以说之前要先扫描完再Create Bean的原因就是这个，而不能边扫描边Create，依赖属性就注入不了
                    //todo 假如我先创建userService,那我要对orderService进行注入,会发现没有这个,我会创建,并将其放到池子里
                    declaredField.set(o, getBean(declaredField.getName()));

                    //??代表什么呢?对于userService来说他就需要一个orderService对象,那如何得到orderService对象呢又?
                }
            }
            //回调(spring告诉bean什么)
            if (o instanceof BeanNameAware) {
                //这个bean是否实现了这个接口,如果是,就会进行强制转换.然后把beanName放进去以供回调
                ((BeanNameAware) o).setBeanName(beanName);
            }
            //这个为什么要放在这个位置,因为如果执行了初始化前操作的时候,就已经是拿到一个代理的对象了.
            for (Method method : targetClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(PostConstruct.class)){
                    //加了这个注解,证明我们要在之前就对这个对象的方法进行执行.
                    //todo 这里有个bug需要处理.求助kys
                    method.invoke(o,null);
                }
            }

            //初始化前
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                //如果什么都没做,直接返回那个对象,如果是userService,就返回代理类
                o = beanPostProcessor.postProcessBeforeInitialization(beanName, o);
            }
            //也可以理解为回调是spring要干什么,初始化是程序员要干什么
            //初始化(spring调用这个bean的某个方法,具体这个方法要干什么spring不关心)
            if (o instanceof InitializingBean) {
                //这个bean是否实现了这个接口,如果是,就会调用这个方法,spring替我们主动调用这个方法了.具体要干什么spring是不操心的
                ((InitializingBean) o).afterPropertiesSet();
            }
            //初始化后
            //前提:BeanPostProcessor  bean的后置处理器
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                o = beanPostProcessor.postProcessAfterInitialization(beanName, o);
            }
            //初始化后,可以干一件非常重要的事情:AOP


            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Object getBean(String beanName) {
        //根据传的名字,找到类,如何区分单例和多例bean
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new NullPointerException("找不到这个bean.  " + beanName);
        } else {
            if ("singleton".equals(beanDefinition.getScope())) {
                //单例
                Object bean = singletonObjects.get(beanName);
                if (null == bean) {
                    //如果拿不到,我们就要去创建
                    Object o = createBean(beanName, beanDefinition);
                    //创建完成后还是得扔回单例池里去
                    singletonObjects.put(beanName, o);
                    return o;
                } else {
                    return bean;

                }
            } else {
                //多例
                return createBean(beanName, beanDefinition);
            }
        }
//        return null;
    }
}
