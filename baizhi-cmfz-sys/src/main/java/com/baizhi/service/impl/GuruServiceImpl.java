package com.baizhi.service.impl;

import com.baizhi.dao.GuruDAO;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import com.baizhi.util.Md5Util;
import com.baizhi.util.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by asd on 2017/6/14.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        String salt = SaltUtils.getSalt();
        guru.setSalt(salt);
        String md5Code = Md5Util.getMd5Code(guru.getPwd() + salt);
        guru.setPwd(md5Code);
        guruDAO.insert(guru);
    }

    public void update(Guru guru) {
        guruDAO.update(guru);
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Guru> queryAll() {
        List<Guru> gurus = guruDAO.selectAll();
        return gurus;
    }

    public Guru selectDetialById(String id) {
        Guru guru = guruDAO.selectDetialById(id);
        return guru;
    }

    public Guru selectById(String id) {
        Guru guru = guruDAO.selectById(id);
        return guru;
    }
}
