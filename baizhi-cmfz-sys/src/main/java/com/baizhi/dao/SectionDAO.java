package com.baizhi.dao;

import com.baizhi.entity.Section;

import java.util.List;

/**
 * Created by asd on 2017/6/15.
 */
public interface SectionDAO extends BaseDAO<Section> {
    List<Section> selectBySpecialId(String id);
}
