package com.baizhi.entity;

import java.util.List;

/**
 * 角色实体
 */

public class Role {
    private String id;
    private String role;
    private Integer avaliable;

    private List<Manager> managerList;

    private List<Perssion> perssionList;

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", avaliable=" + avaliable +
                ", managerList=" + managerList +
                ", perssionList=" + perssionList +
                '}';
    }

    public Role(String id, String role, Integer avaliable, List<Manager> managerList, List<Perssion> perssionList) {
        this.id = id;
        this.role = role;
        this.avaliable=avaliable;
        this.managerList = managerList;
        this.perssionList = perssionList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }

    public List<Perssion> getPerssionList() {
        return perssionList;
    }

    public void setPerssionList(List<Perssion> perssionList) {
        this.perssionList = perssionList;
    }
}
