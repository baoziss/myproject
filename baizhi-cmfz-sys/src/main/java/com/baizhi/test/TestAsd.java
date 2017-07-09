package com.baizhi.test;

import com.baizhi.dao.ManagerDAO;
import com.baizhi.entity.Manager;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basit.xml")
public class TestAsd {
    @Autowired
    private ManagerDAO managerDAO;
    @Autowired
    private UserService userService;
    @Test
    public void testMd5(){
        String asdf = Md5Util.getMd5Code("123456asdf");
        System.out.println(asdf);
    }
    @Test
    public void testManager(){
        Manager huxz = managerDAO.selectByUsername("huxz");
        System.out.println(huxz);
    }
    @Test
    public void testUser(){
        List<User> users = userService.queryAll();
        System.out.println(users);
    }
}
