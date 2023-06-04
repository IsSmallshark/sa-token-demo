package com.example.satoken.controller;

import cn.dev33.satoken.dao.SaTokenDaoRedisJackson;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.example.satoken.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version 1.0
 * @description: TODO
 * @date 2023/6/1 10:18
 */
@RestController
@RequestMapping("/acc/")
public class LoginController {

    private final SaTokenDaoRedisJackson saTokenDaoRedisJackson;

    public LoginController(SaTokenDaoRedisJackson saTokenDaoRedisJackson) {
        this.saTokenDaoRedisJackson = saTokenDaoRedisJackson;
    }

    /**
     * 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
     *
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if ("zhang".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            // 在登录时缓存user对象
            StpUtil.getSession().set("user", UserEntity.builder()
                    .id(1).password("123").username("zss")
                    .build());
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    /**
     * 查询登录状态  ---- http://localhost:8081/acc/isLogin
     *
     * @return
     */
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        //获取当前登陆用户
        UserEntity user = (UserEntity) StpUtil.getSession().get("user");
        SaSession session = StpUtil.getSession();
        String tokenValue = StpUtil.getTokenValue();
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    /**
     * 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
     *
     * @return
     */
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        try {
            String tokenValue = StpUtil.getTokenValue();
            StpUtil.checkLogin();
        } catch (Exception e) {
            System.out.println(e);
        }
        return SaResult.data(StpUtil.getTokenInfo());
    }

    /**
     * 测试注销  ---- http://localhost:8081/acc/logout
     *
     * @return
     */
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}

