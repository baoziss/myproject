package com.baizhi.test;

import com.baizhi.dao.ManagerDAO;
import com.baizhi.entity.Manager;
import com.baizhi.entity.User;
import com.baizhi.entity.Work;
import com.baizhi.service.UserService;
import com.baizhi.service.WorkService;
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
public class TestAwe {
   @Autowired
   private WorkService workService;
    @Test
    public void testWork(){
        workService.update(new Work("1","aa",null,null,null));

    }
    @Test
    public void testAdd(){
        Work work = new Work();
        work.setName("aa");
        workService.add(work);

    }
}
