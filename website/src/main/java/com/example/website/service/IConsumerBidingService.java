package com.example.website.service;

import com.example.website.entity.ConsumerBiding;

public interface IConsumerBidingService {
    /**
     * 投标
     * @param consumerBiding 封装投标信息的对象
     */
    void createConsumerBiding(ConsumerBiding consumerBiding);
}
