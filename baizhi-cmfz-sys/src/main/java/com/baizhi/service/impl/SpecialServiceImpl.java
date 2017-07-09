package com.baizhi.service.impl;

import com.baizhi.dao.SpecialDAO;
import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by asd on 2017/6/15.
 */
@Service
@Transactional
public class SpecialServiceImpl implements SpecialService {
    @Autowired
    private SpecialDAO specialDAO;
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Special> queryAll() {
        List<Special> specials = specialDAO.selectAll();
        return specials;
    }

    public Special queryById(String id) {
        Special special = specialDAO.selectById(id);
        return special;
    }

    public void add(Special special, MultipartFile aa, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/static/images");
        File file1 = new File(realPath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //重命名文件
        String extension = FilenameUtils.getExtension(aa.getOriginalFilename());
        String uuid= UUID.randomUUID().toString();
        String newName=uuid+"."+extension;
        File file = new File(file1.getAbsolutePath(),newName);
        aa.transferTo(file);
        special.setImage("/back/static/images/"+newName);
        special.setId(uuid);
        special.setPublishTime(new Date());
        specialDAO.insert(special);
    }

    public void remove(String id) {
        specialDAO.delete(id);
    }

    public void update(Special special, MultipartFile aa, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/static/images");
        File file1 = new File(realPath);
        //重命名文件
        String extension = FilenameUtils.getExtension(aa.getOriginalFilename());
        String newName=special.getId()+"."+extension;
        File file = new File(file1.getAbsolutePath(),newName);
        aa.transferTo(file);
        special.setImage("/back/static/images/"+newName);
        special.setPublishTime(new Date());
        specialDAO.update(special);
    }
}
