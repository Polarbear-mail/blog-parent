package com.mszlu.blog.service;

import com.mszlu.blog.vo.CategoryVo;

import java.util.List;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/15 18:32
 * @description：
 */

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);
}
