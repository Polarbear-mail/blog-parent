package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.ArticleParam;
import com.mszlu.blog.vo.params.PagePrams;


public interface ArticleService {

    /**
     * 分页查询，文章列表
     * @param pagePrams
     * @return
     */
    Result listArticle(PagePrams pagePrams);


    /**
     * 获取最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);


    /**
     * 获取最新文章
     * @param limit
     * @return
     */
    Result newArticle(int limit);


    /**
     * 文章归档
     * @return
     */
    Result listArchives();

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */

    Result findArticleById(Long articleId);

    /**
     * 文章发布服务
     * @param articleParam
     * @return
     */
    Result publish(ArticleParam articleParam);
}
