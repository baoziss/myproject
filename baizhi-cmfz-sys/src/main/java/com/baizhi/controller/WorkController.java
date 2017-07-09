package com.baizhi.controller;

import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/13.
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Resource
    private WorkService workService;
    @RequestMapping("/add")
    @ResponseBody
    public Map<String ,Object> save(Work work){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            workService.add(work);
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
    public Map<String ,Object> remove(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            workService.remove(id);
            map.put("status",1);
            map.put("message","删除成功");
        }catch (Exception e){
            map.put("status",0);
            map.put("message","删除失败");
        }
        return map;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Work> findAll(){
        List<Work> works = workService.queryAll();
        return works;
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Work findById(String id){
        Work work = workService.queryById(id);
        return work;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String ,Object> update(Work work){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            workService.update(work);
            map.put("status",1);
            map.put("message","修改成功");
        }catch (Exception e){
            map.put("status",0);
            map.put("message","修改失败");
        }
        return map;
    }
}
