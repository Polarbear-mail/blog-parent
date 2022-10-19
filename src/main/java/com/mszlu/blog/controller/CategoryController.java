package com.mszlu.blog.controller;

import com.mszlu.blog.service.CategoryService;
import com.mszlu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/16 15:39
 * @description：
 */

@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public Result categorys(){
        return categoryService.findAll();
    }

    @GetMapping("detail")
    public Result categorysDetail(){
        return categoryService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result categorysDetailById(@PathVariable("id") Long id){
        return categoryService.findAllDetailById(id);
    }
}
