package com.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {

  //设置默认欢迎页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置前台首页路径
        registry.addViewController("/").setViewName("index");//根目录
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        //去到登录页面
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

}
