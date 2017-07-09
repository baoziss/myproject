package com.baizhi.dao;

import com.baizhi.entity.Hphoto;

import java.util.List;

/**
 * Created by asd on 2017/6/13.
 */
public interface HphotoDAO extends BaseDAO<Hphoto> {
    void updateAll(List<String>list);
}
