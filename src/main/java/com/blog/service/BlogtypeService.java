package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Blogtype;


public interface BlogtypeService extends IService<Blogtype> {

    /**
     * 查询每个博客分类下的博客名称及博客数量
     * @return
     * @throws Exception
     */
    String getBlogTypeNameAndBlogCount() throws Exception;
}
