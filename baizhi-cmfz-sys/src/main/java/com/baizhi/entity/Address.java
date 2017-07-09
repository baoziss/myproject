package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/12.
 */
public class Address implements Serializable{
    private String id;
    private String name;
    private String lev;
    private Address address;

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lev='" + lev + '\'' +
                ", address=" + address +
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

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address(String id, String name, String lev, Address address) {

        this.id = id;
        this.name = name;
        this.lev = lev;
        this.address = address;
    }

    public Address() {

    }
}
