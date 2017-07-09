package com.baizhi.dao;

import java.util.List;

/**
 * Created by dell-pc on 2017/6/12.
 */
public interface BaseDAO<T> {

    public List<T> selectAll();

    public T selectById(String id);

    public void insert(T t);

    public void delete(String id);

    public void update(T t);
}
