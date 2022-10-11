package com.mszlu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.pojo.Tag;

import javax.annotation.Resource;
import java.util.List;

public interface TagMapper  extends BaseMapper<Tag> {
    /**
     * 根据文章id 查询标签列表
     * @return
     */
    @Resource
    List <Tag> findTagsByArticleid(Long articleId);
}
