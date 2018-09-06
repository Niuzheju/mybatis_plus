package com.baidu.dao;

import com.baidu.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface UserDao extends BaseMapper<User> {

    Integer getMaxAge();

}
