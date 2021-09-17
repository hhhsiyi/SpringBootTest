package com.hewen.mybatis08.mapper;

import com.hewen.mybatis08.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * 2021/9/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public interface BlogMapper {
    public int addBlog(Blog blog);

    public List<Blog>queryBlogIf(Map map);

    public List<Blog>queryBlogIf1(Map map);

    public List<Blog>queryBlogChoose(Map map);

    public List<Blog>queryBlogForEach(Map ids);

    public List<Blog>queryBlogForEachs(String[] ids);

    public int updateBlog(Map map);

}
