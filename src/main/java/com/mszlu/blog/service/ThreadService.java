package com.mszlu.blog.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.mszlu.blog.dao.mapper.ArticleMapper;
import com.mszlu.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/15 23:01
 * @description：
 */
@Component
public class ThreadService {

    // 期望此操作在线程池执行 不会影响原有的主线程
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts+1);
        // 更新条件
        LambdaUpdateWrapper <Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        // 设置一个为了在多线程的环境下 线程安全,乐观锁
        updateWrapper.eq(Article::getViewCounts,viewCounts);
        // update article set view_counts =100 where view_counts =99 and id =1
        articleMapper.update(articleUpdate,updateWrapper);
        try {
            Thread.sleep(500);
            System.out.println("更新完成了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
