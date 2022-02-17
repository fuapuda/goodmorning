package com.example.website.service;

import com.example.website.entity.Tbidder;

public interface ITbidderService {
    /**
     * 企业注册
     * @param tbidder 封装企业信息的Tbidder对象
     */
    void register(Tbidder tbidder);

    /**
     * 企业登录
     * @param username 用户名
     * @param password 密码
     * @return 封装企业信息的Tbidder对象
     */
    Tbidder login(String username, String password);
}
