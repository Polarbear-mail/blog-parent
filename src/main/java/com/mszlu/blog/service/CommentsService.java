package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.CommentParam;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/16 0:40
 * @description：
 */
public interface CommentsService {
    /**
     * 根据文章ID 查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
