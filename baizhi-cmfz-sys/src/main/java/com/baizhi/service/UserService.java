package com.baizhi.service;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
public interface UserService {
    List<User> queryAll();
    User selectById(String id);
    void update(User user);

    User login(User user);
}
