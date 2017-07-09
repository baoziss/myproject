package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by asd on 2017/6/14.
 */
public class Points implements Serializable{
    private String id;
    private String title;
    private String author;
    private String image;
    @JSONField(format = "yyy-MM-dd")
    private Date publishTime;
    private String url;
    private String status;
}
