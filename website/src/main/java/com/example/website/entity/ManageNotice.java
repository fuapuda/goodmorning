package com.example.website.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ManageNotice {
    private String id;
    private String title;
    private String content;
    private String tb_id;
    private String gmtCreate;
}
