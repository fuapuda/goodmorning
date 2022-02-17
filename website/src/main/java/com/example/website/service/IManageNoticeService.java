package com.example.website.service;

import com.example.website.entity.ManageBid;
import com.example.website.entity.ManageNotice;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IManageNoticeService {

    /**
     * 获取发布的中标信息
     * @return 中标信息列表
     */
    PageInfo<ManageNotice> getNoticeList(Integer pageNum);

    /**
     * 获取id对应中标信息详情
     * @param id 中标信息id
     * @return 中标信息详情
     */
    ManageNotice getNoticeDetails(String id);
}
