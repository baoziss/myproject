package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by asd on 2017/6/14.
 */
public class Speech implements Serializable{
    private String id;
    private String title;
    private String author;
    private String image;
    @JSONField(format = "yyy-MM-dd")
    private Date publishTime;
    private String url;
    private String status;

    @Override
    public String toString() {
        return "Speech{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", publishTime=" + publishTime +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Speech(String id, String title, String author, String image, Date publishTime, String url, String status) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.publishTime = publishTime;
        this.url = url;
        this.status = status;
    }

    public Speech() {

    }
}
