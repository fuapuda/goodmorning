package com.example.website.controller;

import com.example.website.entity.ManageQualifications;
import com.example.website.service.IManageQualificationsService;
import com.example.website.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("qualifications")
public class ManageQualificationsController {
    @Autowired
    IManageQualificationsService qualificationsService;

    @RequestMapping("list")
    R<PageInfo<ManageQualifications>> getQualificationList(Integer pageNum){
        PageInfo<ManageQualifications> pageInfo = qualificationsService.getQualificationList(pageNum);
        return R.ok(pageInfo);
    }
}
