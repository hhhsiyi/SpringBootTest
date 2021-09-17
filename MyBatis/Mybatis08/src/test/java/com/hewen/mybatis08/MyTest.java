package com.hewen.mybatis08;

import com.hewen.mybatis08.mapper.BlogMapper;
import com.hewen.mybatis08.pojo.Blog;
import com.hewen.mybatis08.utils.IDUtils;
import com.hewen.mybatis08.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 2021/9/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class MyTest {
    @Test
    public void test01(){
        String id = IDUtils.getId();
        System.out.println(id);
    }
    @Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog(IDUtils.getId(), "王德虎真帅", "hewen", new Date(), 5);
        int i = mapper.addBlog(blog);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void testIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","康要生真帅");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }
    @Test
    public void testWhereif(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //map.put("title","康要生真帅");
        List<Blog> blog1 = mapper.queryBlogIf(map);
        for (Blog blog : blog1) {
            System.out.println(blog);
        }
        List<Blog> blogs = mapper.queryBlogIf1(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }
    @Test
    public void testWhereChoose(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title","康要生真帅");
        map.put("views",1111);
        map.put("author",1);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void testSet(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title","康要生真帅");
        map.put("id","40b401fcf35e4620aa4361da0eec27b6");
        map.put("views",2048);
        map.put("author","何文");
        int blogs = mapper.updateBlog(map);
        System.out.println(blogs);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testForEach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title","康要生真帅");
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        map.put("ids",integers);
        List<Blog> blogs = mapper.queryBlogForEach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        String s2="1,2,3";
        String[] split = s2.split(",");
        List<Blog> blogs1 = mapper.queryBlogForEachs(split);
        for (Blog blog : blogs1) {
            System.out.println(blog);
        }
    }
}
