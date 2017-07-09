package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        List<User> users = userService.queryAll();
        return users;
    }


    @RequestMapping(value = "/login/{phone}/{pwd}",method = RequestMethod.GET)
    public @ResponseBody User login(@RequestBody @PathVariable("phone")String phone,@PathVariable("pwd")String pwd ){
        User user = new User();
        user.setPwd(pwd);
        user.setPhone(phone);
        try {
            User login = userService.login(user);
            return login;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping("/findById")
    @ResponseBody
    public User findById(String id){
        User user = userService.selectById(id);
        return user;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(User user){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            userService.update(user);
            map.put("status",1);
            map.put("message","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            map.put("message","修改失败");
        }
        return map;
    }
}
