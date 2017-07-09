package com.baizhi.service;

import com.baizhi.entity.Work;

import java.util.List;

/**
 * Created by asd on 2017/6/13.
 */
public interface WorkService {
    void add(Work work);
    void remove(String id);
    List<Work> queryAll();
    Work queryById(String id);
    void update(Work work);
}
