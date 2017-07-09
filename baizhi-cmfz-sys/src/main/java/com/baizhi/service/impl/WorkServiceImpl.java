package com.baizhi.service.impl;

import com.baizhi.dao.WorkDAO;
import com.baizhi.entity.Work;
import com.baizhi.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by asd on 2017/6/13.
 */
@Service
@Transactional
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDAO workDAO;

    public void add(Work work) {
        work.setId(UUID.randomUUID().toString());
        work.setImage("a");
        work.setType("必修");
        workDAO.insert(work);
    }

    public void remove(String id) {
        workDAO.delete(id);
    }
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Work> queryAll() {
        List<Work> works = workDAO.selectAll();
        return works;
    }

    public Work queryById(String id) {
        Work work = workDAO.selectById(id);
        return work;
    }

    public void update(Work work) {
        workDAO.update(work);
    }
}
