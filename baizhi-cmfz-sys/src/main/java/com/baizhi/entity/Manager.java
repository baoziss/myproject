package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/12.
 */
public class Manager implements Serializable {
    private String id;
    private String username;
    private String salt;
    private String pwd;


    public Manager() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
