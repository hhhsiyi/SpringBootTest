package com.example.springbootelasticsearchjd.utils;

import com.example.springbootelasticsearchjd.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 2022/2/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component
public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        new HtmlParseUtil().parseJD("ps5").forEach(System.out::println);
        //目前不支持中文编码，

    }
    public List<Content> parseJD(String keywords) throws IOException {
        //联网，但是不能获取到AJax的
        String url = "https://search.jd.com/Search?keyword="+keywords+"&enc=utf-8";
        //解析网页
        Document document = Jsoup.parse(new URL(url), 30000);
        //jsoup的Document就是浏览器返回的js页面对象，就是浏览器的Document对象
        //J_goodsList
        Element j_goodsList = document.getElementById("J_goodsList");//所有查询结果
//        System.out.println(j_goodsList);
        //获取所有的li元素
        Elements li = j_goodsList.getElementsByTag("li");
        //获取元素中的内容
        List<Content> contents = new ArrayList<>();
        for (Element el : li) {
            //关于图片特多的网站，所有的图片都是延迟加载的！懒加载
//            String img = el.getElementsByTag("img").eq(0).attr("src");
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name p-name-type-2").eq(0).text();
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(name);
            contents.add(new Content(name,price,img));
        }
        return contents;
    }
}
