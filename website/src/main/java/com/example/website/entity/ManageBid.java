package com.example.website.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ManageBid {
    private String id;
    private String title;
    private String departmentId;
    private String img;
    private String file;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;
    private String description;
}
