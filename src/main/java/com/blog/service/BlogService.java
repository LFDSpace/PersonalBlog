package com.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Blog;

/**
 * <p>
 *  服务类
 * </p>

 */
public interface BlogService extends IService<Blog> {
      //查询博客日期和博客数量
      String findBlogDateAndCount() throws Exception;

      //分页查询博客信息
      IPage<Blog> findBlogByPage(IPage<Blog> page,Blog blog);

      //查看博客详情
      Blog findBlogById(int id) throws Exception;

      //查看上一篇博客
      Blog findPrevBlog(int id) throws Exception;
      //查看下一篇博客
      Blog findNextBlog(int id) throws Exception;

      //新增博客
      int addBlog(Blog blog) throws Exception;

      //删除博客
      int deleteBlogById(int blogId)throws Exception;

      //修改博客
      int updateBlog(Blog blog) throws Exception;

      //增加评论数
      int addCommentCounts(int blogId) throws Exception;

}
