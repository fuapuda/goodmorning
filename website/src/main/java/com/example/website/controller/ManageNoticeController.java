package com.example.website.controller;

import com.example.website.entity.ManageNotice;
import com.example.website.service.IManageNoticeService;
import com.example.website.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notices")
public class ManageNoticeController {
    @Autowired
    IManageNoticeService manageNoticeService;

    @RequestMapping("get_notice_list")
    public R<PageInfo<ManageNotice>> getBidList(Integer pageNum){
        PageInfo<ManageNotice> pageInfo =  manageNoticeService.getNoticeList(pageNum);
        return R.ok(pageInfo);
    }

    @RequestMapping("details")
    public R<ManageNotice> getBidDetails(String id){
        ManageNotice manageNotice = manageNoticeService.getNoticeDetails(id);
        return R.ok(manageNotice);
    }
}
