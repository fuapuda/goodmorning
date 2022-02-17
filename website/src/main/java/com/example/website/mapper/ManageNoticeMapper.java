package com.example.website.mapper;

import com.example.website.entity.ManageNotice;

import java.util.List;

public interface ManageNoticeMapper {

    /**
     * 获取发布的中标信息
     * @return 中标信息列表
     */
    List<ManageNotice> findNoticeList();

    /**
     * 根据id查询中标信息详情
     * @param id 中标信息id
     * @return 中标信息详情
     */
    ManageNotice findById(String id);
}
