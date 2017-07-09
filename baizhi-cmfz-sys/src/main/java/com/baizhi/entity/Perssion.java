package com.baizhi.entity;

import java.util.List;
/**
 * 权限实体
 */
public class Perssion {
    private String id;
    private String name;
    private String resource;
    private Integer avaliable;


    private List<Role> roleList;

    public Perssion() {
    }

    @Override
    public String toString() {
        return "Perssion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", resource='" + resource + '\'' +
                ", avaliable=" + avaliable +
                ", roleList=" + roleList +
                '}';
    }

    public Perssion(String id, String name, Integer avaliable, String resource, List<Role> roleList) {
        this.id = id;
        this.name = name;
        this.avaliable = avaliable;
        this.resource = resource;
        this.roleList = roleList;
    }

    public Integer getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Integer avaliable) {
        this.avaliable = avaliable;
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
