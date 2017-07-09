package com.baizhi.service;

import com.baizhi.entity.Speech;
import java.util.List;

/**
 * Created by asd on 2017/6/16.
 */
public interface SpeechService {
    void update(Speech speech);
    List<Speech> queryAll();
}
