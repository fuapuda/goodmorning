package com.example.website.controller;

import com.example.website.entity.ManageItem;
import com.example.website.service.IManageItemService;
import com.example.website.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")
public class ManageItemController {
    @Autowired
    IManageItemService manageItemService;

    @RequestMapping("get_project_list")
    public R<PageInfo<ManageItem>> getProjectList(String category, Integer pageNum) {
        PageInfo<ManageItem> pageInfo = manageItemService.getProjectList(category, pageNum);
        return R.ok(pageInfo);
    }

    @RequestMapping("details")
    public R<ManageItem> getProjectDetails(String id){
        ManageItem manageItem = manageItemService.getProjectDeatils(id);
        return  R.ok(manageItem);
    }
}
