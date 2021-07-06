package com.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.service.BlogtypeService;
import com.blog.dao.BlogtypeMapper;
import com.blog.entity.Blogtype;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class BlogtypeServiceImpl extends ServiceImpl<BlogtypeMapper, Blogtype> implements BlogtypeService {

    @Resource
    private BlogtypeMapper blogtypeMapper;

    //springboot操作redis的对象
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String getBlogTypeNameAndBlogCount() throws Exception {
        //从redis缓存中读取博客分类信息
        String blogTypeInfo = redisTemplate.opsForValue().get("blog_name_count");
        //判断：redis缓存中是否存在分类的数据，如果缓存中没有数据，此时需要从数据库中查询，查询出来的结果要放到redis缓存中
        //为空，则表示缓存没有数据
        if(blogTypeInfo==null || blogTypeInfo.equals("") || blogTypeInfo.length()==0){
            //如果缓存中没有数据，此时需要从数据库中查询，查询出来的结果要放到redis缓存中
            List<Blogtype> blogtypeList = blogtypeMapper.getBlogTypeNameAndBlogCount();
            //将集合转换成json
            blogTypeInfo = JSON.toJSONString(blogtypeList);
            //将集合的数据放到缓存
            redisTemplate.opsForValue().set("blog_name_count",blogTypeInfo);
        }
        return blogTypeInfo;
    }
}