package com.mszlu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszlu.blog.dao.dos.Archives;
import com.mszlu.blog.dao.mapper.ArticleMapper;
import com.mszlu.blog.dao.pojo.Article;
import com.mszlu.blog.service.ArticleService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.service.TagService;
import com.mszlu.blog.vo.ArticleVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.PagePrams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//import org.springframework.data.domain.Page;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result listArticle(PagePrams pagePrams) {
        /**
         * 分页查询 article 数据库表
         */
        Page <Article> page =new Page<>(pagePrams.getPage(), pagePrams.getPageSize());
        LambdaQueryWrapper<Article>  queryWrapper =new LambdaQueryWrapper<>();
        // 是否置顶排序
        //queryWrapper.orderByDesc(Article::getWeight);

        //order by create date desc
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List <Article>  records = articlePage.getRecords();

        //这里不能直接返回
        List <ArticleVo> articleVoList = copyList(records,true,true);
        return Result.success(articleVoList);



    }




    private List<ArticleVo> copyList(List<Article> records,boolean isTag,boolean isAuthor) {
        List <ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,isTag,isAuthor));
        }

        return articleVoList;
    }


    private ArticleVo copy(Article article,boolean isTag,boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(articleVo.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        //并不是所有接口 都需要标签，作者信息
        if (isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleid(articleId));
        }
        if (isAuthor){
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        return articleVo;

    }

    @Override
    public Result hotArticle(int limit) {
        /**
         * 查询最热文章
         * @param limit
         * @return
         */
        LambdaQueryWrapper<Article>  queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id ,title from article order  by view_counts desc limit 4
        List<Article> articles = articleMapper.selectList(queryWrapper);

        return Result.success(copyList(articles,false,false));
    }

    @Override
    public Result newArticle(int limit) {
        /**
         * 获取最新文章
         */
        LambdaQueryWrapper<Article> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+ limit);
        // select id,title from article order by createdata desc limit
        List<Article> articles = articleMapper.selectList(queryWrapper);

        return Result.success(copyList(articles,false,false));
    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList = articleMapper.listArchives();
        return Result.success(archivesList);
    }


}
