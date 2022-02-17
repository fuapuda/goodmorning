package com.example.website.service.impl;

import com.example.website.entity.ManageQualifications;
import com.example.website.mapper.ManageQualificationsMapper;
import com.example.website.service.IManageQualificationsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ManageQualificationsServiceImpl implements IManageQualificationsService {
    @Autowired
    ManageQualificationsMapper manageQualificationsMapper;

    @Value("${qualification.page-size}")
    Integer pageSize;
    @Override
    public PageInfo<ManageQualifications> getQualificationList(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ManageQualifications> list = manageQualificationsMapper.findQualificationList();
        return new PageInfo<>(list);
    }
}
