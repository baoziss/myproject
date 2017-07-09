package com.baizhi.test;

import com.baizhi.dao.HphotoDAO;
import com.baizhi.entity.Hphoto;
import com.baizhi.entity.Work;
import com.baizhi.service.HphotoService;
import com.baizhi.service.WorkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basit.xml")
public class TestHphoto {
   @Autowired
   private HphotoService hphotoService;
    @Autowired
    private HphotoDAO hphotoDAO;
    @Test
    public void test1(){
        List<Hphoto> hphotos = hphotoService.queryAll();
        System.out.println(hphotos);

    }
    @Test
    public void testAdd(){
        Work work = new Work();
        work.setName("aa");
    }
    @Test
    public void testUpAll(){
        List<String> ll=new ArrayList<String>();
        ll.add("42bd5fdc-4225-4796-bb9c-ea8b41a9aa3f");
        ll.add("546990c9-1d21-4ba7-bba1-d4af625792b1");
        hphotoDAO.updateAll(ll);
    }
    @Test
    public void testDelete(){
        File file = new File("back/static/images/0a47e3f63664469cc7f2c846ec18ae18943df3824b12ab29971d6206242bc2c8.jpg");
        file.delete();
    }
    @Test
    public void findOne(){
        Hphoto hphoto = hphotoDAO.selectById("0e4c22b3-301e-4c05-bbbc-d38948b20387");
        System.out.println(hphoto);
    }
}
