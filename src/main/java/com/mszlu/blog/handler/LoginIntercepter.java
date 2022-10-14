package com.mszlu.blog.handler;

import com.alibaba.fastjson.JSON;
import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.service.LoginService;
import com.mszlu.blog.vo.ErrorCode;
import com.mszlu.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/14 15:52
 * @description：
 */

@Component
@Slf4j
public class LoginIntercepter implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行方法之前进行执行
        /**
         * 1. 需要判断请求的接口路径是否为 HandlerMethod(controller方法)
         * 2. 判断token是否为空，如果为空 ，未登录
         * 3. 如果token 不为空，登录验证 logService checkToken
         * 4. 如果认证成功，放行即可
         */
        if (!(handler instanceof HandlerMethod)){
            // handler 可能是RequestsourceHandler
            return true;
        }

        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");


        if (StringUtils.isBlank(token)){
            Result result = Result.fail(ErrorCode.NO_LOGIN.ordinal(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;

        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser ==  null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.ordinal(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }

        // 登录验证成功
        // 我希望在Controller中直接获取用户信息
        return true;
    }
}
