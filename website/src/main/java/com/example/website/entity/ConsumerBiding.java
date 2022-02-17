package com.example.website.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ConsumerBiding {
    private Integer id;
    private Integer tbId;
    private String mbId;
    private String companyName;
    private String username;
    private String file;
    private Date gmtCreate;
    private Date gmtModified;
    private String status;
}
