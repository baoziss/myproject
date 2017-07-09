package com.baizhi.test;

import com.baizhi.dao.SectionDAO;
import com.baizhi.dao.SpecialDAO;
import com.baizhi.entity.Guru;
import com.baizhi.entity.Section;
import com.baizhi.entity.Special;
import com.baizhi.service.GuruService;
import com.baizhi.service.SpecialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basit.xml")
public class TestGuru {
    @Autowired
    private GuruService guruService;

    @Test
    public void test1(){
        List<Guru> gurus = guruService.queryAll();
        for (Guru guru : gurus) {
            System.out.println(guru);
        }
    }

    @Test
    public void test2(){
        Guru guru = guruService.selectDetialById("1");
        System.out.println(guru);
    }

}
