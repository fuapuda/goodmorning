package com.example.website.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Integer id;
    private String name;
    private String email;
    private String content;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModified;
}
