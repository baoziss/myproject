package com.baizhi.dao;

import com.baizhi.entity.Role;
import java.util.List;
/**
 * Created by Administrator on 2017/6/21.
 */
public interface RoleDAO extends BaseDAO<Role> {


    List<Role> selectByManaId(String manaId);
}
