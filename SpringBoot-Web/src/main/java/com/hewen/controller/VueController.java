package com.hewen.controller;

import com.hewen.pojo.BilibiliUserInfo;
import com.hewen.pojo.Vueproject;
import com.hewen.pojo.common.CommonResult;
import com.hewen.utils.MD5Util;
import com.hewen.mapper.VueprojectDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName VueController
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/4/15 23:01
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@Slf4j
public class VueController {
    @Autowired
    private VueprojectDao vueprojectDao;
    @Autowired
    private HttpServletRequest request;
    int base = 100;
    Map<String, BilibiliUserInfo> userInfoMap = new HashMap<>();

    @RequestMapping("/getData1")
    public String getData1() {
        return "1";
    }

    @RequestMapping("/getData2/{id}")
    public String getData2(@PathVariable("id") String id) {
        System.out.println(id);
        return id;
//        这里的请求方式为
//        http://localhost:8081/api/getData2/2
//        这个方法叫获取路径参数
    }

    @RequestMapping("/getData3")
    public String getData3(@RequestParam("id") String id) {
        System.out.println(id);
        return id;
//        这里的请求方式为
//        http://localhost:8081/api/getData3?id=3
//        这个方法叫获取查询参数
    }

    @RequestMapping("/getGoods2")
    public Object getGoods2(@RequestParam("type") String type, @RequestParam("page") String page) {
        Goods goods = new Goods();
        return "1";
//        if (type=="pop"){
//            return goods.getPop();
//        }else if(type=="news"){
//            return goods.getNews();
//        }else {
//            return goods.getSell();
//        }
    }

    @RequestMapping("/getGoods")
    public Object getGoods(@RequestParam("type") String type, @RequestParam("page") String page) {
//        System.out.println("requestGetGoods");
        Goods goods = new Goods();
        log.info("type:{}, page:{}", type, page);
//        return "1";
        int pageSize = 10;
        int currentIndex = Integer.parseInt(page) * pageSize;
        List<New> news = new ArrayList<>();
        List<Pop> pop = new ArrayList<>();
        List<Sell> sell = new ArrayList<>();
        if ("pop".equals(type)) {
            for (int i = currentIndex - 10; i < currentIndex && i < goods.getPop().size(); i++) {
                pop.add(goods.getPop().get(i));
            }
            return pop;
        } else if ("news".equals(type)) {
            for (int i = currentIndex - 10; i < currentIndex && i < goods.getNews().size(); i++) {
                news.add(goods.getNews().get(i));
            }
            return news;
        } else {
            for (int i = currentIndex - 10; i < currentIndex && i < goods.getSell().size(); i++) {
                sell.add(goods.getSell().get(i));
            }
            return sell;
        }
    }

    @RequestMapping("/signUp")
    public CommonResult signUp(@RequestBody BilibiliUserInfo userInfo) {
//        这里来写注册方法,为了省事,我把注册好的账号密码存在内存里!
        CommonResult res = new CommonResult();
        log.info(userInfo.toString());
//        if (userInfoMap.containsKey(userInfo.getId())) {
//            res.setMessage("账号已经存在,请换别的");
//            res.setCode(1);
        if (null!=vueprojectDao.selectByAccountName(userInfo.getAccountName())) {
                res.setMessage("账号已经存在,请换别的");
                res.setCode(1);
        } else {
            userInfo.setPassword(MD5Util.getMD5(userInfo.getPassword()));
            userInfo.setUserToken(MD5Util.getMD5(userInfo.getAccountName() + userInfo.getPassword()));
            userInfo.setId(base++ + "");
            userInfoMap.put(userInfo.getId(), userInfo);
            Vueproject vueproject = new Vueproject();
            BeanUtils.copyProperties(userInfo,vueproject);
            vueprojectDao.insert(vueproject);
            res.setMessage("注册成功,将跳转至登陆页面");
            res.setData(userInfo);
        }
        return res;
//        http://localhost:8081/api/getData3?id=3
    }

    @RequestMapping("/signIn")
    public CommonResult<Vueproject> signIn(@RequestBody BilibiliUserInfo userInfo) {
//        这里来写注册方法,为了省事,我把注册好的账号密码存在内存里!
        CommonResult<Vueproject> res = new CommonResult<>();
        log.info("用户登陆{}", userInfo.toString());
        String accountName = userInfo.getAccountName();
//        if (userInfoMap.containsKey(accountName)) {
//            // 有账号,校验密码
//            if (userInfoMap.get(accountName).getPassword().equals(MD5Util.getMD5(userInfo.getPassword()))) {
//                res.setMessage("登陆成功");
//                res.setData(userInfoMap.get(accountName));
//            } else {
//                res.setCode(1);
//                res.setMessage("密码错误");
//            }
//        } else {
//            res.setCode(1);
//            res.setMessage("用户不存在");
//        }
        Vueproject account = vueprojectDao.selectByAccountName(userInfo.getAccountName());
        if (null!=account) {
            // 有账号,校验密码
            if (account.getPassword().equals(MD5Util.getMD5(userInfo.getPassword()))) {
                res.setMessage("登陆成功");
                res.setData(account);
            } else {
                res.setCode(1);
                res.setMessage("密码错误");
            }
        } else {
            res.setCode(1);
            res.setMessage("账号不存在");
        }
        return res;
//        http://localhost:8081/api/getData3?id=3
    }

    @RequestMapping("/queryUserById")
    public CommonResult<Vueproject> queryUserById(@RequestBody BilibiliUserInfo info) {
        log.info("根据id查询用户{}", info);
        log.info("请求头{}", request.getHeader("Authorization"));
        String token = request.getHeader("Authorization");
        CommonResult<Vueproject> res = new CommonResult<>();
        Vueproject userInfo = vueprojectDao.selectByPrimaryKey(info.getId());
        if (null == userInfo) {
            res.setMessage("查无此人");
            res.setCode(1);
        } else {
            res.setData(userInfo);
        }
        return res;
    }
//    @RequestMapping("/queryUserById")
//    public CommonResult<BilibiliUserInfo> queryUserById(@RequestBody BilibiliUserInfo info) {
//        log.info("根据id查询用户{}", info);
//        log.info("请求头{}", request.getHeader("Authorization"));
//        String token = request.getHeader("Authorization");
//        CommonResult<BilibiliUserInfo> res = new CommonResult<>();
//        BilibiliUserInfo userInfo = userInfoMap.get(info.getId());
//        if (null == userInfo) {
//            res.setMessage("查无此人");
//            res.setCode(1);
//        } else {
//            res.setData(userInfo);
//        }
//        return res;
//    }

    @RequestMapping("/allSignUpUser")
    public CommonResult allSignUpUser() {
        log.info("查询已知注册过的用户");
        CommonResult<List<BilibiliUserInfo>> res = new CommonResult<>();
        List<BilibiliUserInfo> userInfoList = new ArrayList<>();
        if (userInfoMap.size() == 0) {
            res.setMessage("没用户");
            res.setCode(1);
        } else {
            userInfoMap.forEach((s, userInfo) -> {
                userInfoList.add(userInfo);
            });
            res.setData(userInfoList);
        }
        return res;
    }

}


class Goods implements Serializable {
    List<New> news = new ArrayList<>();
    List<Pop> pop = new ArrayList<>();
    List<Sell> sell = new ArrayList<>();

    public Goods() {
        for (int i = 1; i < 30; i++) {
            news.add(new New(300 + i * 10 + "", "文学" + i));
            pop.add(new Pop(300 + i * 10 + "", "流行" + i));
            sell.add(new Sell(300 + i * 10 + "", "畅销" + i));
        }
    }

    public List<New> getNews() {
        return news;
    }

    public void setNews(List<New> news) {
        this.news = news;
    }

    public List<Pop> getPop() {
        return pop;
    }

    public void setPop(List<Pop> pop) {
        this.pop = pop;
    }

    public List<Sell> getSell() {
        return sell;
    }

    public void setSell(List<Sell> sell) {
        this.sell = sell;
    }

    public List<Object> getGoods() {
        return goods;
    }

    public void setGoods(List<Object> goods) {
        this.goods = goods;
    }

    List<Object> goods = new ArrayList<Object>();

    @Override
    public String toString() {
        return "Goods{" +
                "news=" + news +
                ", goods=" + goods +
                '}';
    }
}

class New {
    String price;
    String name;
    String imgUrl = "//img11.360buyimg.com/seckillcms/s140x140_jfs/t1/212633/19/8502/16883/61c024cbE1c3863cc/e5499bf60be85376.jpg.webp";

    public New(String price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

class Pop {
    String price;
    String name;
    String imgUrl = "//img30.360buyimg.com/seckillcms/s140x140_jfs/t1/176154/11/27817/92008/6221c856E8d9f27d3/244f5ea86865f979.jpg.webp";

    public Pop(String price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

class Sell {
    String price;
    String name;
    String imgUrl = "//img30.360buyimg.com/seckillcms/s140x140_jfs/t1/120595/12/27876/175876/62566113E322df526/48558d341f795f63.png.webp";

    public Sell(String price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}



