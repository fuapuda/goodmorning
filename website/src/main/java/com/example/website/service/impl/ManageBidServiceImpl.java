package com.example.website.service.impl;

import com.example.website.entity.ManageBid;
import com.example.website.entity.News;
import com.example.website.ex.BidInfoNotFoundException;
import com.example.website.mapper.ManageBidMapper;
import com.example.website.service.IManageBidService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageBidServiceImpl implements IManageBidService {
    @Autowired
    ManageBidMapper manageBidMapper;

    @Override
    public List<ManageBid> getLatelyBid() {
        return manageBidMapper.findLatelyBid();
    }

    @Value("${bid.page-size}")
    Integer pageSize;
    @Override
    public PageInfo<ManageBid> getBidList(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ManageBid> list = manageBidMapper.findBidList();
        return new PageInfo<>(list);
    }

    @Override
    public ManageBid getBidDetails(String id) {
        ManageBid manageBid = manageBidMapper.findById(id);
        return manageBid;
    }
}
