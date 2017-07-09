package com.baizhi.service.impl;

import com.baizhi.dao.SpeechDAO;
import com.baizhi.entity.Speech;
import com.baizhi.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asd on 2017/6/16.
 */
@Transactional
@Service
public class SpeechServiceImpl implements SpeechService {
    @Autowired
    private SpeechDAO speechDAO;

    public void update(Speech speech) {
        speechDAO.update(speech);
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Speech> queryAll() {
        List<Speech> speeches = speechDAO.selectAll();
        return speeches;
    }
}
