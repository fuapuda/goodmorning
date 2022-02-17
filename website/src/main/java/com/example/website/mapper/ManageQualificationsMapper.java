package com.example.website.mapper;

import com.example.website.entity.ManageQualifications;

import java.util.List;

public interface ManageQualificationsMapper {
    /**
     * 获取企业资质信息
     * @return 资质信息列表
     */
    List<ManageQualifications> findQualificationList();
}
