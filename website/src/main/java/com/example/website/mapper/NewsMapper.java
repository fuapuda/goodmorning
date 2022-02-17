package com.example.website.mapper;

import com.example.website.entity.News;

import java.util.List;

public interface NewsMapper {

    /**
     * 根据新闻类别查询新闻
     * @param category 新闻类别
     * @return 新闻列表
     */
    List<News> findByCategory(Integer category);

    /**
     * 根据新闻类别获取最近发布的新闻
     * @param category　新闻类别
     * @param limit　获取条数
     * @return　新闻列表
     */
    List<News> findＬatelyNews(Integer category, Integer limit);

    /**
     * 根据id查询对应的新闻
     * @param id
     * @return 查询id对应的新闻
     */
    News findById(String id);
}
