package com.example.website.service.impl;

import com.example.website.entity.News;
import com.example.website.mapper.NewsMapper;
import com.example.website.service.INewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;

    @Value("${news.page-size}")
    Integer pageSize;

    @Override
    public PageInfo<News> getByCategroy(Integer pageNum, Integer categroy) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsList = newsMapper.findByCategory(categroy);
        return new PageInfo<>(newsList);
    }

    @Override
    public List<News> getLatelyNews(Integer categroy, Integer limit) {
        return newsMapper.findＬatelyNews(categroy, limit);
    }

    @Override
    public News getNewsDetails(String id) {
        News news = newsMapper.findById(id);
        return news;
    }
}
