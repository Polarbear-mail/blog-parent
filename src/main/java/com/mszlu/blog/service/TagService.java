package com.mszlu.blog.service;


import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.TagVo;

import java.util.List;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/11 17:15
 * @description：
 */
public interface TagService {
    List<TagVo> findTagsByArticleid(Long articleId);

    Result hots(int limit);


    /**
     * 查询所有的文章标签
     */

    Result findAll();

    Result findAllDetail();
}

