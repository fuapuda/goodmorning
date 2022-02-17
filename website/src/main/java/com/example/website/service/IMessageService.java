package com.example.website.service;

import com.example.website.entity.Message;

public interface IMessageService {
    /**
     * 创建留言信息
     * @param message 封装留言信息的 Message 对象
     */
    void createMessage(Message message);
}
