package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * Created by asd on 2017/6/12.
 */
public interface UserDAO extends BaseDAO<User> {
    User selectByGuruId(String id);

    User selectByPhone(String phone);
}
