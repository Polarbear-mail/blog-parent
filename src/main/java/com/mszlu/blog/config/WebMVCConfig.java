package com.mszlu.blog.config;

import com.mszlu.blog.handler.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：Polarbear
 * @date ：Created 2022/9/23 15:08
 * @description：
 */

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter loginIntercepter;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，不可设置为*，不安全, 前后端分离项目，可能域名不一致
        //本地测试 端口不一致 也算跨域
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截test接口，后续 实际遇到的问题需要拦截的接口时，再配置真正的拦截接口
        registry.addInterceptor(loginIntercepter).
                addPathPatterns("/test")
                .addPathPatterns("/articles/publish")
                .addPathPatterns("/comments/create/change");
    }
}
