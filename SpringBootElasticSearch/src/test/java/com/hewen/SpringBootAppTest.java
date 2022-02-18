package com.hewen;

import com.alibaba.fastjson.JSON;
import com.hewen.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 2022/2/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootTest
public class SpringBootAppTest {
    @Autowired//默认根据类型去匹配
    private RestHighLevelClient restHighLevelClient;

    //api讲解 7.6.x高级客户端
    @Test
    void testCreateIndex() throws IOException {
        /**
         * 1.创建索引请求
         * 2.执行创建请求
         */
        CreateIndexRequest request = new CreateIndexRequest("hewen_index2");
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    void testExistIndex() throws IOException {
        /**
         * 获取索引
         * 判断是否存在
         */
        GetIndexRequest getIndexRequest = new GetIndexRequest("hewen_index");
        boolean getIndexResponse = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse);
    }

    @Test
    void testDeleteIndex() throws IOException {
        /**
         * 获取索引
         * 判断是否存在
         */
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("hewen_index2");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    //    @Test
//    void contextLoads(){
//
//    }
    @Test
    void testAddDoc() throws IOException {
        /**
         * 1.创建对象
         * 2.创建请求
         * 3.指定规则
         * 4.将数据放入请求
         * 5.发送请求获取响应的结果
         */
        User u1 = new User("何文", 24);
        IndexRequest request = new IndexRequest("hewen_test_doc");
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        IndexRequest source = request.source(JSON.toJSONString(u1), XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(index.toString());
        System.out.println(index.status());//CREATED对应我们
        //IndexResponse
        // [index=hewen_test_doc,type=_doc,id=1,version=1,result=created,seqNo=0,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
        //对象转换成json放入库中
    }
    @Test
    void testExistDoc() throws IOException {
        /**
         * 获取索引
         * 判断是否存在
         */
        GetRequest getRequest = new GetRequest("hewen_test_doc","1");
        //不获取返回的上下文，效率会更高
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    void testGetDoc() throws IOException {
        /**
         * 获取文档内容
         */
        GetRequest getRequest = new GetRequest("hewen_test_doc","1");
        //不获取返回的上下文，效率会更高
//        getRequest.fetchSourceContext(new FetchSourceContext(false));
//        getRequest.storedFields("_none_");

        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());
        System.out.println(getResponse.toString());
    }

    @Test
    void testUpdateDoc() throws IOException {
        /**
         * 获取文档内容
         */
        User u1 = new User("何文222", 25);
        UpdateRequest updateRequest = new UpdateRequest("hewen_test_doc","1");
        updateRequest.timeout("1s");
        updateRequest.doc(JSON.toJSONString(u1),XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.status());//OK
        System.out.println(update.toString());
    }

    @Test
    void testDeleteDoc() throws IOException {
        /**
         * 获取文档内容
         */
        User u1 = new User("何文222", 25);
        DeleteRequest deleteRequest = new DeleteRequest("hewen_test_doc","1");
        deleteRequest.timeout("1s");
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.status());//OK
        System.out.println(delete.toString());
    }
    //特殊的，批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("hewen", 21));
        users.add(new User("何文2", 22));
        users.add(new User("何文3", 23));
        users.add(new User("何文4", 24));
        users.add(new User("何文5", 25));
        users.add(new User("何文6", 26));
        for (int i = 0; i < users.size(); i++) {
            bulkRequest.add(new IndexRequest("hewen_test_doc")
//                    .id((i+1)+"")//如果不指定id，就会生成无序id，会影响效率
                    .source(JSON.toJSONString(users.get(i)),XContentType.JSON));
        }
        //批处理请求，批量更新和批量删除其实也就这样。
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());
        System.out.println(bulk.hasFailures());//有失败的吗，返回false就是成功 的
    }

    //查询
    //搜索请求、条件构造、高亮构造、精确查询
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        //构建搜索的条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.highlighter();
        //term精确匹配
        //matchAll匹配所有包括分词了的
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "ps5");
        //中文查不出来需要把name改成name.keyword
        //可以使用queryBuilders快速构建匹配
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(termQueryBuilder);
//                .from();
;
        sourceBuilder.timeout(new TimeValue(60,TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search.getHits()));
        for (SearchHit hit : search.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }
}