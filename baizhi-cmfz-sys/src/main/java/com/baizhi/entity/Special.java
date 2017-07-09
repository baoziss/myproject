package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang.text.StrTokenizer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by asd on 2017/6/14.
 */
public class Special implements Serializable {
    private String id;
    private String title;
    private String image;
    private String author;
    private String announcer;
    private Integer score;
    private Integer size;
    private String content;
    @JSONField(format = "yyy-MM-dd")
    private Date publishTime;
    private List<Section> sections;

    @Override
    public String toString() {
        return "Special{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", announcer='" + announcer + '\'' +
                ", score=" + score +
                ", size=" + size +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", sections=" + sections +
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Special(String id, String title, String image, String author, String announcer, Integer score, Integer size, String content, Date publishTime, List<Section> sections) {

        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.announcer = announcer;
        this.score = score;
        this.size = size;
        this.content = content;
        this.publishTime = publishTime;
        this.sections = sections;
    }

    public Special() {

    }
}
