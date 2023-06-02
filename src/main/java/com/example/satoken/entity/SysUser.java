package com.example.satoken.entity;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import lombok.Data;

/**
 * @author xsq
 * @version 1.0
 * @description: TODO
 * @date 2023/6/1 19:53
 */
@Data
public class SysUser {

    private Integer id;
    private String name;
    private Integer age;
}
