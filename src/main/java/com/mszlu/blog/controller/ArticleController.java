package com.mszlu.blog.controller;

import com.mszlu.blog.service.ArticleService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PagePrams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/9/27 10:44
 * @description：
 */
//json 数据交互
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private  ArticleService articleService;



    /**
     * 请求首页文章列表
     * @param pagePrams
     */
    @PostMapping
    public Result listArticle(@RequestBody PagePrams pagePrams){
        return articleService.listArticle(pagePrams);
    }
}
