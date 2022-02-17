package com.example.website.mapper;

import com.example.website.entity.ManageBid;

import java.util.List;

public interface ManageBidMapper {
    /**
     * 获取最近发布的招标信息
     * @return 招标信息列表
     */
    List<ManageBid> findLatelyBid();

    /**
     * 获取发布的招标信息
     * @return 招标信息列表
     */
    List<ManageBid> findBidList();

    /**
     * 根据id查询招标信息详情
     * @param id 招标信息id
     * @return 招标信息详情
     */
    ManageBid findById(String id);
}
