package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/guru")
public class GuruController {
    @Resource
    private GuruService guruService;
    //、save、update、findAll、findBy.
    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> save(Guru guru){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            guruService.add(guru);
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
    public Map<String, Object> update(Guru guru){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            guruService.update(guru);
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
    public List<Guru> findAll(){
        List<Guru> gurus = guruService.queryAll();
        return gurus;
    }
    @RequestMapping("/findById")
    @ResponseBody
    public Guru findById(String id){
        Guru guru = guruService.selectById(id);
        return guru;
    }

    @RequestMapping("/findDetialById")
    @ResponseBody
    public Guru findDetialById(String id){
        Guru guru = guruService.selectDetialById(id);
        return guru;
    }

}
