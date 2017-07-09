package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by asd on 2017/6/12.
 */
public class User implements Serializable {
    private String id;
    private String phone;
    private String pwd;
    private String status;
    private String fname;
    private String name;
    private String sex;
    private String salt;
    private String head;
    private String sign;
    private String image;
    //地址 上师
    private Address address;
    private Guru guru;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", status='" + status + '\'' +
                ", fname='" + fname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", sign='" + sign + '\'' +
                ", image='" + image + '\'' +
                ", address=" + address +
                ", guru=" + guru +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public User(String id, String phone, String pwd, String status, String fname, String name, String sex, String salt, String head, String sign, String image, Address address, Guru guru) {

        this.id = id;
        this.phone = phone;
        this.pwd = pwd;
        this.status = status;
        this.fname = fname;
        this.name = name;
        this.sex = sex;
        this.salt = salt;
        this.head = head;
        this.sign = sign;
        this.image = image;
        this.address = address;
        this.guru = guru;
    }

    public User() {

    }
}
