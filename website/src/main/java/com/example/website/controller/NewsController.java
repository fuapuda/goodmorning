package com.example.website.controller;

import com.example.website.entity.News;
import com.example.website.service.INewsService;
import com.example.website.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    INewsService newsService;

    @RequestMapping("get_news_list")
    public PageInfo<News> getByCategory(Integer pageNum, Integer category){
        return newsService.getByCategroy(pageNum, category);
    }

    @RequestMapping("get_lately_news")
    public List<News> getLatelyNews(Integer category, Integer limit){
        return newsService.getLatelyNews(category, limit);
    }

    @RequestMapping("details")
    public R<News> getNewsDetails(String id){
        News news = newsService.getNewsDetails(id);
        return R.ok(news);
    }
}
