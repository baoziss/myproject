package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
public class Guru implements Serializable{
    private String id;
    private String name;
    private String username;
    private String pwd;
    private String status;
    private String salt;
    private String image;
    private List<User> users;
    private List<Points> points;
    private List<Speech> speeches;

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status='" + status + '\'' +
                ", salt='" + salt + '\'' +
                ", image='" + image + '\'' +
                ", users=" + users +
                ", points=" + points +
                ", speeches=" + speeches +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }

    public List<Speech> getSpeeches() {
        return speeches;
    }

    public void setSpeeches(List<Speech> speeches) {
        this.speeches = speeches;
    }

    public Guru(String id, String name, String username, String pwd, String status, String salt, String image, List<User> users, List<Points> points, List<Speech> speeches) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.pwd = pwd;
        this.status = status;
        this.salt = salt;
        this.image = image;
        this.users = users;
        this.points = points;
        this.speeches = speeches;
    }

    public Guru() {

    }
}
