package com.yk.dao;

import java.util.List;
import com.yk.orm.PageVO;
import com.yk.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);
    //分页要带这个参数
    List<User> selectAll(PageVO<User> user);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}