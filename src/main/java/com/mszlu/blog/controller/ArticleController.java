package com.mszlu.blog.controller;

import com.mszlu.blog.common.aop.LogAnnotation;
import com.mszlu.blog.service.ArticleService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.ArticleBodyParam;
import com.mszlu.blog.vo.params.ArticleParam;
import com.mszlu.blog.vo.params.PagePrams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Polarbear
 * @date ：Created 2022/9/27 10:44
 * @description： 测试喔
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
    // 加上此注解可对当前接口记录日志
    @LogAnnotation(module="文章",operater= "获取文章列表")
    public Result listArticle(@RequestBody PagePrams pagePrams){
//        int i = 10/0;
        return articleService.listArticle(pagePrams);
    }


    /**
     * 首页 最热文章
     */
    @PostMapping("hot")
    public Result hotArticle(){
        int limit =5;
        return articleService.hotArticle(limit);
    }


    /**
     * 首页 最新文章
     */
    @PostMapping("new")
    public Result newArticle(){
        int limit =5;
        return articleService.newArticle(limit);
    }

    /**
     * 首页  文章归档
     */
    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }


    /**
     * 文章内容详情
     */

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }


    //接口url：/articles/publish
    //
    //请求方式：POST
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }






}
