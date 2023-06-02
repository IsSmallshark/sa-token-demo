package com.example.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.example.satoken.entity.UserEntity;
import com.example.satoken.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author xsq
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 14:59
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user
     * @return
     */
    @PostMapping("doLogin")
    public String doLogin(@RequestBody UserEntity user) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if(StrUtil.equals("zs", user.getUsername()) && StrUtil.equals("123", user.getPassword())) {
            StpUtil.login(1002222);
            return "登录成功";
        }
        return "登录失败";
    }

    /**
     * 查询登录状态
     * @return
     */
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @GetMapping("/getUserInfo")
    public UserEntity getUserInfo(Integer id) {
        return userService.selectById(id);
    }

}
