package com.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;


@TableName("t_blogtype")
public class Blogtype implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客分类编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 博客分类名称
     */
    @TableField("typeName")
    private String typeName;

    /**
     * 博客优先级排序
     */
    @TableField("orderNo")
    private Integer orderNo;
    //每个博客分类下的博客数量 (数据库表中不存在），要忽略掉它 mybatisPlus使用TableField(exit=false)
    @TableField(exist = false)
    private Integer blogCount;
    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "Blogtype{" +
        "id=" + id +
        ", typeName=" + typeName +
        ", orderNo=" + orderNo +
        "}";
    }
}
