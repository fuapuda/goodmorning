package com.example.website.service.impl;

import com.example.website.entity.ManageBid;
import com.example.website.entity.ManageNotice;
import com.example.website.mapper.ManageNoticeMapper;
import com.example.website.service.IManageNoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageNoticeServiceImpl implements IManageNoticeService {
    @Autowired
    ManageNoticeMapper manageNoticeMapper;

    @Value("${bid.page-size}")
    Integer pageSize;
    @Override
    public PageInfo<ManageNotice> getNoticeList(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<ManageNotice> list = manageNoticeMapper.findNoticeList();
        return new PageInfo<>(list);
    }

    @Override
    public ManageNotice getNoticeDetails(String id) {
        ManageNotice manageNotice = manageNoticeMapper.findById(id);
        return manageNotice;
    }
}
