package com.example.website.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Tbidder {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String contactsName;
    private String phone;
    private String companyName;
    private String file;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
}
