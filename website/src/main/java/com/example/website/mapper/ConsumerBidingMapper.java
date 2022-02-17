package com.example.website.mapper;

import com.example.website.entity.ConsumerBiding;

public interface ConsumerBidingMapper {
    /**
     * 添加一条投标信息
     * @param consumerBiding 封装投标信息的consumerBiding对象
     * @return 受影响的行数
     */
    Integer insert(ConsumerBiding consumerBiding);

    /**
     * 根据 companyName 和 String mbId 查询
     * @param companyName 企业名称
     * @param mbId 招标信息id
     * @return 投标信息
     */
    ConsumerBiding findByCompanyNameAndMbId(String companyName, String mbId);

    /**
     * 修改file值
     * @param consumerBiding 封装投标信息的consumerBiding对象
     * @return 受影响的行数
     */
    Integer updateFile(ConsumerBiding consumerBiding);
}
