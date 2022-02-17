package com.example.website.service.impl;

import com.example.website.entity.Tbidder;
import com.example.website.ex.*;
import com.example.website.mapper.TbidderMapper;
import com.example.website.service.ITbidderService;
import com.example.website.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TbidderServiceImpl implements ITbidderService {
    @Autowired
    TbidderMapper mapper;

    @Override
    public void register(Tbidder tbidder) {
        // 基于tbidder的getUsername()获取用户名
        String username = tbidder.getUsername();
        // 调用持久层方法findBytbiddername,看tbidder是否不为null
        Tbidder result = mapper.findByUsername(username);
        // 不为null;抛出TbiddernameDuplicateException
        if (result != null) {
            throw new UsernameDuplicateException("企业注册异常！用户名已存在");
        }

        // 基于tbidder的getCompanyName()获取企业名称
        String companyName = tbidder.getCompanyName();
        // 调用持久层方法findByCompanyName,看tbidder是否不为null
        result = mapper.findByCompanyName(companyName);
        // 不为null;抛出TbiddernameDuplicateException
        if (result != null) {
            throw new CompanyNameDuplicateException("企业注册异常！该企业已注册!");
        }

        // 向tbidder中补全数据
        // 补全盐值
        String salt = UUID.randomUUID().toString();
        tbidder.setSalt(salt);
        // 获取用户输入的密码
        String password = tbidder.getPassword();
        // 基于盐值对密码进行加密
        String newPassword = PasswordUtils.encode(password, salt);
        // 将加密后的密码添加到tbidder中
        tbidder.setPassword(newPassword);
        // 补全is_delete为0
        tbidder.setIsDelete(0);
        Date now = new Date();
        // 补全4项目日志数据
        tbidder.setGmtModified(now);
        tbidder.setGmtModified(now);

        // 调用mapper的addnew(),将用户数据添加到数据库
        Integer row = mapper.insert(tbidder);
        // 查看返回的行数是否不为1
        if (!row.equals(1)) {
            // 是： 抛出InsertException
            throw new InsertException("用户注册异常！请联系管理员");
        }
    }

    @Override
    public Tbidder login(String username, String password) {
        // 调用持久层的findByUsername(username) -> User
       Tbidder tbidder = mapper.findByUsername(username);
        // 判断User对象是否为null
        if (tbidder == null) {
            // 是: 抛出 UserNotFoundException
            throw new UserNotFoundException("登录异常! 用户名不存在");
        }

        // 获取user中的isDelete
        Integer isDelete = tbidder.getIsDelete();
        // 判断isDelete是否为1
        if (isDelete.equals(1)) {
            // 是: 抛出 UserNotFoundException
            throw new UserNotFoundException("登录异常！用户名不存在");
        }

        // 获取查询到的盐值
        String salt = tbidder.getSalt();
        // 对用户传入的密码进行加密
        String md5Password = PasswordUtils.encode(password, salt);
        // 判断两个密码是否不一致
        if (!md5Password.equals(tbidder.getPassword())) {
            // 是：抛出 PasswordNotMatchException
            throw new PasswordNotMatchException("登录异常！ 密码不正确");
        }

        // 将盐值设为null
        tbidder.setSalt(null);
        // 将密码设为null
        tbidder.setPassword(null);
        // 将isDelete设为null
        tbidder.setIsDelete(null);
        // 返回user
        return tbidder;
    }
}
