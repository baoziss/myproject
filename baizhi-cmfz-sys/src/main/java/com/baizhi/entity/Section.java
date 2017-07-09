package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/14.
 */
public class Section implements Serializable {
    private String id;
    private String name;
    private String size;
    private String url;
    private Special special;

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", special=" + special +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public Section(String id, String name, String size, String url, Special special) {

        this.id = id;
        this.name = name;
        this.size = size;
        this.url = url;
        this.special = special;
    }

    public Section() {

    }
}
