package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PagePrams;


public interface ArticleService {

    /**
     * 分页查询，文章列表
     * @param pagePrams
     * @return
     */
    Result listArticle(PagePrams pagePrams);

}
