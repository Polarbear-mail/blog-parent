package com.mszlu.blog.service;

import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.LoginPram;
import org.springframework.beans.factory.annotation.Autowired;

public interface LoginService {

    /**
     * 登录功能
     * @param loginPram
     * @return
     */
    Result login(LoginPram loginPram);

    SysUser checkToken(String token);

    /**
     * 推出登录
     * @param token
     * @return
     */
    Result logout(String token);
}
