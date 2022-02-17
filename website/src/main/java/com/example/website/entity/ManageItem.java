package com.example.website.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ManageItem {
    private String id;
    private String name;
    private String img;
    private Integer isDeleted;
    private Date gmtCreate;
    private Date gmtModified;
    private String status;
    private String department;
    private String description;
}
