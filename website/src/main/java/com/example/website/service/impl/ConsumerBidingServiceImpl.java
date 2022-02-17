package com.example.website.service.impl;

import com.example.website.entity.ConsumerBiding;
import com.example.website.entity.ManageBid;
import com.example.website.ex.BidInfoNotFoundException;
import com.example.website.ex.InsertException;
import com.example.website.ex.UpdateException;
import com.example.website.mapper.ConsumerBidingMapper;
import com.example.website.mapper.ManageBidMapper;
import com.example.website.mapper.TbidderMapper;
import com.example.website.service.IConsumerBidingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsumerBidingServiceImpl implements IConsumerBidingService {
    @Autowired
    ConsumerBidingMapper consumerBidingMapper;
    @Autowired
    ManageBidMapper manageBidMapper;

    @Override
    public void createConsumerBiding(ConsumerBiding consumerBiding) {
        Date now = new Date();
        ManageBid manageBid = manageBidMapper.findById(consumerBiding.getMbId());
        if (manageBid == null) {
            throw new BidInfoNotFoundException("投标失败!招标信息不存在");
        }
        // 补全日志数据
        consumerBiding.setGmtCreate(now);
        consumerBiding.setGmtModified(now);
        // 如果该企业对该招标信息进行了更新投标,则更新投标文件
        ConsumerBiding result = consumerBidingMapper.findByCompanyNameAndMbId(consumerBiding.getCompanyName(), consumerBiding.getMbId());
        if (result != null) {
            Integer row = consumerBidingMapper.updateFile(consumerBiding);
            if (row != 1) {
                throw new UpdateException("投标失败!请联系管理员");
            }
        } else {
            // 调用insert方法执行添加操作
            Integer row = consumerBidingMapper.insert(consumerBiding);
            if (row != 1) {
                throw new InsertException("投标失败!请联系管理员");
            }
        }
    }
}
