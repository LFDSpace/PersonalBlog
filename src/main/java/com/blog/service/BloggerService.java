package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Blog;
import com.blog.entity.Blogger;

public interface BloggerService extends IService<Blogger> {
    //根据博主名称查询博主信息
    Blogger findBloggerByUserName(String userName) throws Exception;

}
