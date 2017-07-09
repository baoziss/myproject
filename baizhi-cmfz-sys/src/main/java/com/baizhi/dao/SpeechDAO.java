package com.baizhi.dao;

import com.baizhi.entity.Speech;

import java.util.List;

/**
 * Created by asd on 2017/6/14.
 */
public interface SpeechDAO extends BaseDAO<Speech> {
    List<Speech> selectByGuruId(String id);
}
