package com.baizhi.service.impl;

import com.baizhi.dao.SectionDAO;
import com.baizhi.entity.Section;
import com.baizhi.entity.Special;
import com.baizhi.service.SectionService;
import com.baizhi.util.ConvertFileSize;
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
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionDAO sectionDAO;

    public void add(Section section, MultipartFile aa, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/back/static/file");
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
        section.setUrl("/back/static/file/"+newName);
        section.setId(uuid);
        long size = aa.getSize();
        String sizeString = ConvertFileSize.convert(size);
        section.setSize(sizeString);
        sectionDAO.insert(section);
    }

    public void remove(String id) {
        sectionDAO.delete(id);
    }

    public void update(Section section) {
        sectionDAO.update(section);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Section> queryBySpecialId(String id) {
        List<Section> sections = sectionDAO.selectBySpecialId(id);
        return sections;
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Section> queryAll() {
        List<Section> sections = sectionDAO.selectAll();
        return sections;
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Section queryById(String id) {
        Section section = sectionDAO.selectById(id);
        return section;
    }
}
