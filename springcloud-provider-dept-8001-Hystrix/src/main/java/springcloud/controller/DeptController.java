package springcloud.controller;

import com.hewen.springcloud.pojo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.service.DeptService;

import java.util.List;

//提供RestFul服务！
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        System.out.println("ooOK");
//        Dept dept = deptService.queryById1(id);
        Dept dept = null;
        System.out.println("noOK");
        if (dept == null) {
            throw new RuntimeException("这个id不存在:" + id + "  信息无法找到");
        }
        return dept;
    }
    // 备选方案
    public Dept hystrixGet(Long id) {
        return new Dept().setDeptno(id).setDname("这个id不存在:" + id + "  信息无法找到@hystrix").setDb_source("no database");
    }

    //    @PostMapping("/dept/add")//用get去提交东西不安全
//    public boolean addDept(Dept dept) {
//        return deptService.addDept(dept);
//    }
    @RequestMapping("/dept/add")//用get去提交东西不安全
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    //TODO如果出现用restFul方式传递参数却丢失值的情情况，请添加@RequestBody注解
//    @RequestMapping("/dept/add")//用get去提交东西不安全
//    public boolean addDept1(Dept dept) {
//
//        return deptService.addDept(dept);
//    }

    //http://localhost:8001/dept/get/1
//    @RequestMapping("/dept/get/{id}")
//    public Dept queryById(@PathVariable("id") Long id) {
//        return deptService.queryById(id);
//    }
//
//    //http://localhost:8001/dept/queryAll
//    @RequestMapping("/dept/queryAll")
//    public List<Dept> queryAll() {
//        return deptService.queryAll();
//    }
//
//    @Autowired//用来获取一些注册中心的信息
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("/dept/t1")
//    public Object discovery() {
//        //获取微服务列表清单
//        //一般自动注册注册接口就行
//        List<String> services = discoveryClient.getServices();
//        System.out.println("discovery->" + services);
//        //获取一个具体的微服务信息,通过applicationname去拿
//        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
//        for (ServiceInstance instance : instances
//        ) {
//            System.out.println(instance.getHost() + " "
//                    + instance.getPort() + " "
//                    + instance.getUri() + " "
//                    + instance.getServiceId());
//        }
//        return this.discoveryClient;
//    }
//
//    @RequestMapping("/testRest")
//    public String t() {
//        System.out.println("1");
//        return "2";
//    }
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @RequestMapping("/testRest2")
//    public void tt() {
//        String url = "http://localhost:8001/testRest";
//        String url2 = "http://SPRINGCLOUD-PROVIDER-DEPT/testRest";
//        String forObject = (String) restTemplate.getForObject(url2, String.class);
//        System.out.println("\n" + forObject);
//    }

}
