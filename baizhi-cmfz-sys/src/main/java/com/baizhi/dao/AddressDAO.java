package com.baizhi.dao;

import com.baizhi.entity.Address;

import java.util.List;

/**
 * Created by asd on 2017/6/13.
 */
public interface AddressDAO extends BaseDAO<Address> {
    Address selectByTwoId(String id);
}
