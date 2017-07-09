package com.baizhi.controller;

import com.baizhi.dao.SectionDAO;
import com.baizhi.entity.Section;
import com.baizhi.service.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asd on 2017/6/16.
 */
@Controller
@RequestMapping("/section")
public class SectionController {
    @Resource
    private SectionService sectionService;
    //update、remove、findAll、findBy...
    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Section section, MultipartFile aa, HttpServletRequest request) throws IOException {
        System.out.println(section.getSpecial().getId());
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            sectionService.add(section,aa,request);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Section section){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            sectionService.update(section);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }

    @RequestMapping("/remove")
    @ResponseBody
    public Map<String,Object> remove(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            sectionService.remove(id);
            map.put("status",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status",0);
        }
        return map;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Section> findAll(){
        List<Section> sections=sectionService.queryAll();
        return sections;
    }

    @RequestMapping("/findByspecialId")
    @ResponseBody
    public List<Section> findByspecialId(String id){
        List<Section> sections=sectionService.queryBySpecialId(id);
        return sections;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Section findById(String id){
        Section section = sectionService.queryById(id);
        return section;
    }
}
