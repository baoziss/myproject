package com.baizhi.dao;


import com.baizhi.entity.Manager;

/**
 * Created by asd on 2017/6/12.
 */
public interface ManagerDAO extends BaseDAO<Manager>  {
    Manager selectByUsername(String username);
}
