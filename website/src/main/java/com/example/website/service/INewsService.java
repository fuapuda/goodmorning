package com.example.website.service;

import com.example.website.entity.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface INewsService {
    /**
     * 显示新闻列表
     * @param categroy 新闻类别
     * @return 新闻列表
     */
    PageInfo<News> getByCategroy(Integer pageNum, Integer categroy);

    /**
     * 获取最近发布的新闻
     * @param categroy　新闻类别
     * @return　新闻列表
     */
    List<News> getLatelyNews(Integer categroy, Integer limit);

    /**
     * 获取新闻详情
     * @param id 新闻id
     * @return 封装新闻详情的News对象
     */
    News getNewsDetails(String id);
}
