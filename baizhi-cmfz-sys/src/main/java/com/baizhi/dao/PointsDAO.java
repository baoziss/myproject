package com.baizhi.dao;

import com.baizhi.entity.Points;

import java.util.List;

/**
 * Created by asd on 2017/6/14.
 */
public interface PointsDAO extends BaseDAO<Points>{
    List<Points> selectByGuruId(String id);
}
