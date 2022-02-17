package com.example.website.service.impl;

import com.example.website.entity.ManageItem;
import com.example.website.mapper.ManageItemMapper;
import com.example.website.service.IManageItemService;
import com.example.website.util.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageItemServiceImpl implements IManageItemService {
    @Autowired
    ManageItemMapper manageItemMapper;

    @Value("${project.page-size}")
    Integer pageSize;
    @Override
    public PageInfo<ManageItem> getProjectList(String department, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ManageItem> projects = manageItemMapper.findProjectList(department);
        return new PageInfo<>(projects);
    }

    @Override
    public ManageItem getProjectDeatils(String id) {
        ManageItem manageItem = manageItemMapper.findById(id);
        return manageItem;
    }
}
