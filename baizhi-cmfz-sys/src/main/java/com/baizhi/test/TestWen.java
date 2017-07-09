package com.baizhi.test;

import com.baizhi.dao.HphotoDAO;
import com.baizhi.dao.SectionDAO;
import com.baizhi.dao.SpecialDAO;
import com.baizhi.entity.Hphoto;
import com.baizhi.entity.Section;
import com.baizhi.entity.Special;
import com.baizhi.entity.Work;
import com.baizhi.service.HphotoService;
import com.baizhi.service.SpecialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basit.xml")
public class TestWen {
   @Autowired
   private SpecialService specialService;
    @Autowired
    private SpecialDAO specialDAO;
    @Autowired
    private SectionDAO sectionDAO;
    @Test
    public void test1(){
        List<Special> specials = specialService.queryAll();
        for (Special special : specials) {
            System.out.println(special);
        }
    }
    @Test
    public void test2(){
        Special special = specialService.queryById("1");
        System.out.println(special);
    }
    @Test
    public void test4(){
        Section section = new Section();
        section.setId("asdasdz1");
        section.setSize("1k");
        Special special = new Special();
        special.setId("55");
        section.setSpecial(special);
        section.setName("asd");
        section.setUrl("aaa");
        sectionDAO.insert(section);
    }
    @Test
    public void test3(){
        Special special = new Special();
        special.setId("4");
        special.setPublishTime(new Date());
        special.setImage("22");
        special.setAnnouncer("11");
        special.setAuthor("22");
        special.setContent("111");
        special.setScore(11);
        special.setSize(12);
        special.setTitle("asd");
        specialDAO.update(special);
    }
}
