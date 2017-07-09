package com.baizhi.controller;

import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/15.
 */
@Controller
@RequestMapping("/special")
public class SpecialController {
    @Resource
    private SpecialService specialService;
    //save、update、remove、findAll、findBy...
    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Special special, MultipartFile aa, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            specialService.add(special,aa,request);
            map.put("status",1);
            map.put("message","添加成功");
        }catch (Exception e){
            map.put("status",0);
            map.put("message","添加失败");
        }
        return map;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map<String,Object> remove(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            specialService.remove(id);
            map.put("status",1);
            map.put("message","删除成功");
        }catch (Exception e){
            map.put("status",0);
            map.put("message","删除失败");
        }
        return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Special special,MultipartFile aa, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            specialService.update(special,aa,request);
            map.put("status",1);
            map.put("message","修改成功");
        }catch (Exception e){
            map.put("status",0);
            map.put("message","修改失败");
        }
        return map;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Special> findAll(){
        List<Special> specials = specialService.queryAll();
        return specials;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Special findById(String id){
        Special special = specialService.queryById(id);
        return special;
    }
}
