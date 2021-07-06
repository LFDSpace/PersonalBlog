package com.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.entity.Blogtype;


import java.util.List;

public interface BlogtypeMapper extends BaseMapper<Blogtype> {
    //查询每个博客分类下的博客名称
    List<Blogtype> getBlogTypeNameAndBlogCount() throws Exception;
}
