package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Comment;

import java.util.List;


public interface CommentService extends IService<Comment> {

    //根据博客id查询该博客下的评论列表
    List<Comment> findCommentByBlogId(int id, int state) throws Exception;

    //根据博客id删除评论
    int deleteCommentByBlogId(int blogId)  throws Exception;

}
