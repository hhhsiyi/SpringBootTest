package com.example.springbootelasticsearchjd.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootelasticsearchjd.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 2022/2/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/parse/{keywords}")
    public Boolean parse(@PathVariable("keywords") String keywords) throws IOException {
        return contentService.parseContent(keywords);
    }

    @RequestMapping("/parse2")
    public Boolean parse2(@RequestBody String keywords) throws IOException {
        Map parse = (Map)JSON.parse(keywords);
        String keywords1 = (String) parse.get("keywords");
        return contentService.parseContent(keywords1);
    }

    @RequestMapping("/search")
    public List<Map<String,Object>> search(@RequestBody String data) throws IOException {
        Map map = (Map)JSON.parse(data);
        String keywords = (String) map.get("keywords");
        Integer pageNo = Integer.parseInt((String) map.get("pageNo"));
        Integer pageSize = Integer.parseInt((String) map.get("pageSize"));
        List<Map<String, Object>> maps = contentService.searchPage(keywords, pageNo, pageSize);
        return maps;
    }
    @RequestMapping("/searchHighLight")
    public List<Map<String,Object>> searchHighLight(@RequestBody String data) throws IOException {
        Map map = (Map)JSON.parse(data);
        String keywords = (String) map.get("keywords");
        Integer pageNo = Integer.parseInt((String) map.get("pageNo"));
        Integer pageSize = Integer.parseInt((String) map.get("pageSize"));
        List<Map<String, Object>> maps = contentService.searchPageHighLight(keywords, pageNo, pageSize);
        return maps;
    }

    @RequestMapping("search2/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(
            @PathVariable("keywords") String keywords,
            @PathVariable("pageNo") int pageNo,
            @PathVariable("pageSize") int pageSize) throws IOException {
        List<Map<String, Object>> maps = contentService.searchPage(keywords, pageNo, pageSize);
        return maps;
    }

    @RequestMapping("searchHighLight2/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> searchHighLight2(
            @PathVariable("keywords") String keywords,
            @PathVariable("pageNo") int pageNo,
            @PathVariable("pageSize") int pageSize) throws IOException {
        List<Map<String, Object>> maps = contentService.searchPageHighLight(keywords, pageNo, pageSize);
        return maps;
    }
}
