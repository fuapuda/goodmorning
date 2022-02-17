package com.example.website.mapper;

import com.example.website.entity.Tbidder;

public interface TbidderMapper {
    /**
     * 添加一条企业信息
     * @param tbidder 封装企业信息的Tbidder对象
     * @return 企业信息
     */
    Integer insert(Tbidder tbidder);

    /**
     * 根据username查询企业信息
     * @param username 用户名
     * @return 企业信信息
     */
    Tbidder findByUsername(String username);

    /**
     * 根据companyName查询企业是否存在
     * @param companyName 企业名称
     * @return 企业信息
     */
    Tbidder findByCompanyName(String companyName);
}
