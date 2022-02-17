package com.example.website.service;

import com.example.website.entity.ManageQualifications;
import com.github.pagehelper.PageInfo;

public interface IManageQualificationsService {
    /**
     * 获取企业资质信息
     * @param pageNum 页码
     * @return 资质信息列表
     */
    PageInfo<ManageQualifications> getQualificationList(Integer pageNum);
}
