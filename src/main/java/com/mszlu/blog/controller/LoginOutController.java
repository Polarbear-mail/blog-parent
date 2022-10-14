package com.mszlu.blog.controller;

import com.mszlu.blog.service.LoginService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginPram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.StringTokenizer;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/14 13:49
 * @description：
 */

@RestController
@RequestMapping("logout")
public class LoginOutController {
    @Autowired
    private LoginService loginService;

    @GetMapping
    public Result loginout(@RequestHeader("Authorization") String token) {
        // 登录 验证用户 访问用户表
        return loginService.logout(token);
    }
}
