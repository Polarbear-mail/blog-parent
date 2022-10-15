package com.mszlu.blog.controller;

import com.mszlu.blog.service.CommentsService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/16 0:37
 * @description：
 */

@RestController
@RequestMapping("comments")
public class ConmmentsController {
    @Autowired
    private CommentsService commentsService;

    ///comments/article/{id}
    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long id){
        return commentsService.commentsByArticleId(id);

    }
}
