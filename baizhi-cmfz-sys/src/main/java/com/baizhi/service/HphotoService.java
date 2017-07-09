package com.baizhi.service;

import com.baizhi.entity.Hphoto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by asd on 2017/6/13.
 */
public interface HphotoService {
    void add(Hphoto hphoto, MultipartFile aa, HttpServletRequest request) throws IOException;
    void update(Hphoto hphoto);
    List<Hphoto> queryAll();
    Hphoto queryById(String id);
    void remove(String id,HttpServletRequest request);
    void updateAll(List<String> list);
}
