package com.example.website.controller;

import com.example.website.entity.Message;
import com.example.website.service.IMessageService;
import com.example.website.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {
    @Autowired
    IMessageService service;

    @RequestMapping("create")
    public R createMessage(Message message) {
        service.createMessage(message);
        return R.ok();
    }
}
