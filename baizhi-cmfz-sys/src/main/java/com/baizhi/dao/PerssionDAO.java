package com.baizhi.dao;

import com.baizhi.entity.Perssion;
import java.util.List;
/**
 * 权限相关DAO
 */
public interface PerssionDAO extends BaseDAO<Perssion>{

    //根据角色id获得权限
    List<Perssion> selectByRoleId(String roleId);

}
