package com.example.website.service;

import com.example.website.entity.ManageBid;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IManageBidService {
    /**
     * 获取最近发布的招标信息
     * @return 招标信息列表
     */
    List<ManageBid> getLatelyBid();

    /**
     * 获取发布的招标信息
     * @return 招标信息列表
     */
    PageInfo<ManageBid> getBidList(Integer pageNum);

    /**
     * 获取id对应招标信息详情
     * @param id 招标信息id
     * @return 招标信息详情
     */
    ManageBid getBidDetails(String id);
}
