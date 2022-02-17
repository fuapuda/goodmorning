package com.example.website.service;

import com.example.website.entity.ManageItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IManageItemService {
    /**
     * 获取所有属于department类别的项目
     * @param department 类别
     * @return 项目信息列表
     */
    PageInfo<ManageItem> getProjectList(String department, Integer pageNum);

    /**
     * 获取项目详情
     * @param id 项目编号
     * @return 项目详情
     */
    ManageItem getProjectDeatils(String id);
}
