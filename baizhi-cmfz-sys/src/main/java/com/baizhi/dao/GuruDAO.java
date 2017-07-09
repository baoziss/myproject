package com.baizhi.dao;

import com.baizhi.entity.Guru;

/**
 * Created by asd on 2017/6/13.
 */
public interface GuruDAO extends BaseDAO<Guru> {
    Guru selectDetialById(String id);
}
