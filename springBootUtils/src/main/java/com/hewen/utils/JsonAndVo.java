package com.hewen.utils;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021/10/22
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RestController
public class JsonAndVo {
    //这个类里主要是用来测试json报文和vo实体类相互转换的
    @RequestMapping("/json")
    public Map getTestJson(@RequestBody String data){
        Map<String,Object> map = new Gson().fromJson(data, Map.class);
        String card = (String)map.get("card");
        Object t1vo = map.get("t1vo");
        Object t2vo = map.get("t2v");
        String s = new Gson().toJson(t1vo);
        String s2 = new Gson().toJson(t2vo);
        T1VO t1VO = new Gson().fromJson(s, T1VO.class);
        T2VO t2VO = new Gson().fromJson(s2, T2VO.class);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("t1vo",t1VO);
        map1.put("t2vo",t2VO);
        map1.put("card",card);
        System.out.println(s);
        System.out.println(card);
        System.out.println(1);
        return map1;
    }
}
