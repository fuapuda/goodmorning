package com.example.website.mapper;

import com.example.website.entity.Message;

public interface MessageMapper {
    /**
     * 添加一条留言信息
     * @param message 封装留言信息的 Message 对象
     * @return 受影响行数
     */
    Integer insert(Message message);
}
