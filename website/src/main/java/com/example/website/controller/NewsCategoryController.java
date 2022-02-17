package com.example.website.controller;

import com.example.website.entity.NewsCategory;
import com.example.website.service.INewsCategoryService;
import com.example.website.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("news_categorys")
public class NewsCategoryController {
    @Autowired
    INewsCategoryService newsCategoryService;

    @RequestMapping("list")
    public R<List<NewsCategory>> getNewsCategoryList() {
        List<NewsCategory> list = newsCategoryService.getNewsCategoryList();
        return R.ok(list);
    }

    @RequestMapping("info")
    public NewsCategory getNewsCategory(Integer category) {
        return newsCategoryService.getNewsCategoryInfo(category);
    }
}
