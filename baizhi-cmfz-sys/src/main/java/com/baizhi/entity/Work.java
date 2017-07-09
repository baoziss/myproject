package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/13.
 */
public class Work implements Serializable{
    private String id;
    private String name;
    private String image;
    private String type;
    private String userId;

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Work(String id, String name, String image, String type, String userId) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.userId = userId;
    }

    public Work() {

    }
}
