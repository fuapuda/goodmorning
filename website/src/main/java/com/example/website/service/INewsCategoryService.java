package com.example.website.service;

import com.example.website.entity.News;
import com.example.website.entity.NewsCategory;

import java.util.List;

public interface INewsCategoryService {
    /**
     * 获取所有的新闻类别信息
     * @return 新闻类别信息列表
     */
    List<NewsCategory> getNewsCategoryList();

    /**
     * 获取新闻类别信息
     * @param id 新闻类别
     * @return 新闻类别信息
     */
    NewsCategory getNewsCategoryInfo(Integer id);
}
