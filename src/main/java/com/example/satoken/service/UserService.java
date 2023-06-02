package com.example.satoken.service;

import com.example.satoken.entity.UserEntity;

/**
 * @author null
 */
public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    UserEntity selectById(Integer id);
}
