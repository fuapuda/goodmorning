package com.example.website.mapper;

import com.example.website.entity.ManageItem;

import java.util.List;

public interface ManageItemMapper {
    /**
     * 查询属于department的项目信息
     * @param department 项目类别
     * @return 项目列表
     */
    List<ManageItem> findProjectList(String department);

    /**
     * 获取项目详情
     * @param id 项目id
     * @return 项目详情
     */
    ManageItem findById(String id);
}
