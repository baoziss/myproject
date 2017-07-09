package com.baizhi.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by Administrator on 2017/6/20.
 */
public class TestMd5 {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","09xz",1024);
        System.out.println(md5Hash);
    }
}
