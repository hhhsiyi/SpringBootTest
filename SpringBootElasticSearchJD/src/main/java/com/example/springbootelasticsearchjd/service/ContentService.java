package com.example.springbootelasticsearchjd.service;

import com.alibaba.fastjson.JSON;
import com.example.springbootelasticsearchjd.pojo.Content;
import com.example.springbootelasticsearchjd.utils.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 2022/2/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Service
//业务
public class ContentService {
    @Autowired
    private RestHighLevelClient client;
    //解析数据，放入es索引库中
    @Autowired
    private HtmlParseUtil htmlParseUtil;

    //数据入库
    public Boolean parseContent(String keywords) throws IOException {
        List<Content> contents = htmlParseUtil.parseJD(keywords);
        //把数据批量插入es中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i = 0; i < contents.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_goods").source(JSON.toJSONString(contents.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();//没有失败，就返回false，！之后就变成了true
    }

    //实现搜索功能
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        //条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", keyword);//查不出来可能是因为精确匹配
        sourceBuilder
                .query(termQueryBuilder)
                .timeout(new TimeValue(60, TimeUnit.SECONDS))
                .from(pageNo)
                .size(pageSize);
        sourceBuilder.highlighter();
        searchRequest.source(sourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //解析结果
        List<Map<String, Object>> maps = new ArrayList<>();
        for (SearchHit hit : search.getHits().getHits()) {
            maps.add(hit.getSourceAsMap());
        }
        return maps;
    }

    public List<Map<String, Object>> searchPageHighLight(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        //条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", keyword);//查不出来可能是因为精确匹配
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder
                .field("name")
                .preTags("<span style='color:red'>")
                .requireFieldMatch(false)//关闭多个高亮显示
                .postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);
        sourceBuilder
                .query(termQueryBuilder)
                .timeout(new TimeValue(60, TimeUnit.SECONDS))
                .from(pageNo)
                .size(pageSize);
        searchRequest.source(sourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        //解析结果
        List<Map<String, Object>> maps = new ArrayList<>();
        for (SearchHit hit : search.getHits().getHits()) {
            //解析高亮的字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField name = highlightFields.get("name");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();//原来的结果
            //将原来的结果换成高亮的结果
            if (name != null) {
                String nName = "";
                Text[] fragments = name.fragments();
                for (Text t :
                        fragments) {
                    nName += t;
                }
                sourceAsMap.put("name", nName);//替换掉这里原来的内容就行了
            }
            maps.add(hit.getSourceAsMap());
        }
        return maps;
    }
}
