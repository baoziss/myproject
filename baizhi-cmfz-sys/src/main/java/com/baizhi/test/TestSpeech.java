package com.baizhi.test;

import com.baizhi.dao.SpeechDAO;
import com.baizhi.entity.Guru;
import com.baizhi.entity.Speech;
import com.baizhi.service.GuruService;
import com.baizhi.service.SpeechService;
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
public class TestSpeech {
    @Autowired
    private SpeechService speechService;
    @Autowired
    private SpeechDAO speechDAO;

    @Test
    public void test1(){
        List<Speech> speeches = speechService.queryAll();
        for (Speech speech : speeches) {
            System.out.println(speech);
        }
    }


}
