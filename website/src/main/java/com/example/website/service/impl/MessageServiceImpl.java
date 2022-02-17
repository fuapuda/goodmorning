package com.example.website.service.impl;

import com.example.website.entity.Message;
import com.example.website.ex.InsertException;
import com.example.website.mapper.MessageMapper;
import com.example.website.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    MessageMapper mapper;

    @Override
    public void createMessage(Message message) {
        Date now = new Date();
        // 补全日志字段
        message.setGmtCreate(now);
        message.setGmtModified(now);
        Integer row = mapper.insert(message);
        if (row != 1) {
            throw new InsertException("添加留言信息失败! 请联系管理员");
        }
    }
}
