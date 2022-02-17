package com.example.website.service.impl;

import com.example.website.entity.News;
import com.example.website.entity.NewsCategory;
import com.example.website.mapper.NewsCategoryMapper;
import com.example.website.mapper.NewsMapper;
import com.example.website.service.INewsCategoryService;
import com.example.website.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryServiceImpl implements INewsCategoryService {

    @Autowired
    NewsCategoryMapper newsCategoryMapper;


    @Override
    public List<NewsCategory> getNewsCategoryList() {
        return newsCategoryMapper.findNewsCategoryList();
    }

    @Override
    public NewsCategory getNewsCategoryInfo(Integer id) {
        return newsCategoryMapper.findById(id);
    }
}
