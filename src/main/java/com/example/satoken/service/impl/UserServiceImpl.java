package com.example.satoken.service.impl;

import com.example.satoken.entity.UserEntity;
import com.example.satoken.mapper.UserMapper;
import com.example.satoken.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xsq
 * @version 1.0
 * @description: TODO
 * @date 2023/5/27 14:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    public UserEntity selectById(Integer id) {
        return userMapper.selectOneById(id);
    }
}
