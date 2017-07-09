package com.baizhi.controller;

import com.baizhi.entity.Speech;
import com.baizhi.service.SpeechService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/16.
 */
@RequestMapping("/speech")
@Controller
public class SpeechController {
    @Resource
    private SpeechService speechService;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Speech> findAll(){
        List<Speech> speeches = speechService.queryAll();
        return speeches;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String,Object> update(Speech speech){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            speechService.update(speech);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }
}
