package com.example.website.mapper;

import com.example.website.entity.NewsCategory;

import java.util.List;

public interface NewsCategoryMapper {

    /**
     * 获取所有的新闻类别信息
     * @return 新闻类别信息列表
     */
    List<NewsCategory> findNewsCategoryList();

    /**
     * 根据id查询新闻类别信息
     * @param id 类别id
     * @return 类别信息
     */
    NewsCategory findById(Integer id);
}
