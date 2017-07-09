package com.baizhi.service;

import com.baizhi.entity.Guru;

import java.util.List;

/**
 * Created by asd on 2017/6/14.
 */
public interface GuruService {
    //add、update、remove、queryAll、queryBy
    void add(Guru guru);
    void update(Guru guru);
    List<Guru> queryAll();
    Guru selectById(String id);
    Guru selectDetialById(String id);
}
