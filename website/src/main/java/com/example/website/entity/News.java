package com.example.website.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable {
    private String id;
    private Integer category;
    private String title;
    private String introduction;
    private Date gmtCreate;
    private String image;
    private String content;
    private String status;
}
