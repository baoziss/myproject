package com.baizhi.service;

import com.baizhi.entity.Special;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by asd on 2017/6/15.
 */
public interface SpecialService {
    List<Special> queryAll();
    Special queryById(String id);
    void add(Special special,MultipartFile aa, HttpServletRequest request) throws IOException;
    void remove(String id);
    void update(Special special,MultipartFile aa, HttpServletRequest request)throws IOException;
}
