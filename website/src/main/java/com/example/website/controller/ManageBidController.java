package com.example.website.controller;

import com.example.website.entity.ManageBid;
import com.example.website.service.IManageBidService;
import com.example.website.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bids")
public class ManageBidController {
    @Autowired
    IManageBidService manageBidService;

    @RequestMapping("get_bid_list")
    public R<PageInfo<ManageBid>> getBidList(Integer pageNum){
        PageInfo<ManageBid> pageInfo =  manageBidService.getBidList(pageNum);
        return R.ok(pageInfo);
    }

    @RequestMapping("details")
    public R<ManageBid> getBidDetails(String id){
        ManageBid manageBid = manageBidService.getBidDetails(id);
        return R.ok(manageBid);
    }
}
