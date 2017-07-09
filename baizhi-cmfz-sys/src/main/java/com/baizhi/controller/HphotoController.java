package com.baizhi.controller;

import com.baizhi.entity.Hphoto;
import com.baizhi.service.HphotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/13.
 */
@Controller
@RequestMapping("/hphoto")
public class HphotoController {
    @Resource
    private HphotoService hphotoService;

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Hphoto hphoto,MultipartFile aa,HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            hphotoService.add(hphoto,aa,request);
            map.put("status",1);
            map.put("message","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            map.put("message","添加失败");
        }
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Hphoto hphoto){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            hphotoService.update(hphoto);
            map.put("status",1);
            map.put("message","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            map.put("message","修改失败。");
        }
        return map;
    }
    @RequestMapping("/updateAll")
    @ResponseBody
    public Map<String, Object> updateAll(CollectionVO vo){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(vo.getList()!=null){hphotoService.updateAll(vo.getList());}
            map.put("status",1);
            map.put("message","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            map.put("message","修改失败");
        }
        return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Hphoto> findAll(){
        List<Hphoto> hphotos = hphotoService.queryAll();
        return hphotos;
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Hphoto findById(String id){
        Hphoto hphoto = hphotoService.queryById(id);
        return hphoto;
    }
    @RequestMapping("/remove")
    @ResponseBody
    public Map<String,Object> remove(String id,HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            hphotoService.remove(id,request);
            map.put("status",1);
            map.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
            map.put("message","删除失败。");
        }
        return map;
    }
}
