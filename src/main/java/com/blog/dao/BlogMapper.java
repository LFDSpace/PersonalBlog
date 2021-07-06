package com.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import com.blog.entity.Blog;


import java.util.List;

public interface BlogMapper extends BaseMapper<Blog> {

    // 查询博客日期和博客数量
    List<Blog> findBlogDateAndCount() throws Exception;

    // 分页查询博客信息(管理页面也使用）
    IPage<Blog> findBlogByPage(@Param("page") IPage<Blog> page, @Param("blog") Blog blog);

    //查看博客详情
    Blog findBlogById(int id) throws Exception;

    //查看上一篇博客
    Blog findPrevBlog(int id) throws Exception;

    //查看下一篇博客
    Blog findNextBlog(int id) throws Exception;

    //增加评论数
    int addCommentCounts(int blogId);
}
