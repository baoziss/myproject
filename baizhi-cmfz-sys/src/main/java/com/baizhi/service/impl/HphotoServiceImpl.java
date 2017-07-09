package com.baizhi.service.impl;

import com.baizhi.dao.HphotoDAO;
import com.baizhi.entity.Hphoto;
import com.baizhi.service.HphotoService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by asd on 2017/6/13.
 */
@Service
@Transactional
public class HphotoServiceImpl implements HphotoService {
    @Autowired
    private HphotoDAO hphotoDAO;

    public void add(Hphoto hphoto, MultipartFile aa, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/static/images");
        File file1 = new File(realPath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //重命名文件
        String extension = FilenameUtils.getExtension(aa.getOriginalFilename());
        String uuid=UUID.randomUUID().toString();
        String newName=uuid+"."+extension;
        File file = new File(file1.getAbsolutePath(),newName);
        aa.transferTo(file);
        hphoto.setUrl("/back/static/images/"+newName);
        hphoto.setId(uuid);
        hphotoDAO.insert(hphoto);
    }

    public void update(Hphoto hphoto) {
        hphotoDAO.update(hphoto);
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Hphoto> queryAll() {
        List<Hphoto> hphotos = hphotoDAO.selectAll();
        return hphotos;
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Hphoto queryById(String id) {
        Hphoto hphoto = hphotoDAO.selectById(id);
        return hphoto;
    }

    public void remove(String id,HttpServletRequest request) {
        //查出来地址
        Hphoto hphoto = hphotoDAO.selectById(id);
        String src=hphoto.getUrl();
        //删除数据
        hphotoDAO.delete(id);
        //删除图片
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath+src);
        System.out.println(realPath+src);
        file.delete();
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public void updateAll(List<String> list) {
        hphotoDAO.updateAll(list);
    }
}
