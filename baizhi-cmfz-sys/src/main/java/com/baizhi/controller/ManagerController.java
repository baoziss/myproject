package com.baizhi.controller;

import com.baizhi.entity.Manager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by asd on 2017/6/12.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/login")
    public String login(Manager manager) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(manager.getUsername(),manager.getPwd()));
        } catch (UnknownAccountException e) {
            return "redirect:/back/main/main.jsp?mess=用户不存在";
        } catch (IncorrectCredentialsException e){
            return "redirect:/back/main/main.jsp?mess=密码错误";
        }
        return "redirect:/back/main/main.jsp";
    }


}
