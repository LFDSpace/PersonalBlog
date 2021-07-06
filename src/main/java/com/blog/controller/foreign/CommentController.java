package com.blog.controller.foreign;


import com.alibaba.fastjson.JSON;
import com.blog.entity.Comment;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.utils.SysConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/comment")
public class CommentController {


    @Resource
    private CommentService commentService;

    @Resource
    private BlogService blogService;

    @ResponseBody
    @PostMapping("/addComment")
    public String addComment(Comment comment){
        Map<String,Object> map = new HashMap<String, Object>();
        //设置评论信息
        try {
            comment.setCommentDate(new Date());//评论时间就是当前系统时间
            comment.setState(SysConstant.COMMENT_STATE_OK);//未审核2 审核1
            if (comment.getState()==2){
                System.out.println("测试测试测试测试");
                blogService.addCommentCounts(comment.getBlogId());
            }
            comment.setUserIp(InetAddress.getLocalHost().getHostAddress());//获取当前ip地址
            //调用添加评论的方法
            //该save()方法是MyBatisPlus自带的方法
            boolean flag = commentService.save(comment);
            if(flag){
                map.put("success",true);//成功
            }else{
                map.put("success",false);//失败
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

}

