package com.example.satoken.mapper;

import com.example.satoken.entity.UserEntity;
import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author null
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    @Select("select * from user_test where id = #{id}")
    UserEntity selectById(@Param("id") String id);
}
