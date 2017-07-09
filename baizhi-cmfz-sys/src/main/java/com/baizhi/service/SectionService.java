package com.baizhi.service;

import com.baizhi.entity.Section;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by asd on 2017/6/15.
 */
public interface SectionService {
    //add、update、remove、queryAll、queryBy
    void add(Section section, MultipartFile aa, HttpServletRequest request) throws IOException;
    void remove(String id);
    void update(Section section);
    List<Section> queryBySpecialId(String id);
    List<Section> queryAll();
    Section queryById(String id);

}
