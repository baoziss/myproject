package com.baizhi.service.impl;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asd on 2017/6/12.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        List<User> users = userDAO.selectAll();
        return users;
    }

    public User selectById(String id) {
        User user = userDAO.selectById(id);
        return user;
    }

    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(User user) {

        User user1 = userDAO.selectByPhone(user.getPhone());
        if(user1==null){
            throw new RuntimeException("用户不存在！");
        }else if(user.getPwd().equals(user1.getPwd())){
            return user1;
        }else {
            throw new RuntimeException("密码错误！");
        }
    }
}
