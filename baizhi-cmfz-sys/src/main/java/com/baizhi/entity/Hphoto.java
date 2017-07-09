package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/13.
 */
public class Hphoto implements Serializable {
    private String id;
    private String des;
    private String url ;
    private String type;

    @Override
    public String toString() {
        return "Hphoto{" +
                "id='" + id + '\'' +
                ", des='" + des + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hphoto() {

    }

    public Hphoto(String id, String des, String url, String type) {

        this.id = id;
        this.des = des;
        this.url = url;
        this.type = type;
    }
}
