package com.example.website.entity;
import lombok.Data;
import java.util.Date;

@Data
public class ManageQualifications {
    private String id;
    private String name;
    private String img;
    private Integer isDeleted;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;
}
