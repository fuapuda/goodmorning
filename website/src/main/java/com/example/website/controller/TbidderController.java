package com.example.website.controller;

import com.example.website.entity.Tbidder;
import com.example.website.ex.*;
import com.example.website.service.ITbidderService;
import com.example.website.service.OssService;
import com.example.website.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("tbidders")
public class TbidderController {
    @Autowired
    private OssService ossService;
    @Autowired
    ITbidderService service;

    @Value("${project.fileupload.register-file.base-dir}")
    String uploadBaseDir;
    @Value("${project.fileupload.register-file.max-size}")
    long uploadMaxSize;
    @Value("${project-fileupload.register-file.content-types}")
    List<String> contentTypes;
    @PostMapping(value = "register")
    public R register(Tbidder tbidder, MultipartFile fileName) {
        // 检查上传的文件是否为空
        if (fileName.isEmpty()) {
            throw new FileEmptyException("上传附件失败! 请选择有效的附件!");
        }
        // 检查上传的文件大小
        if (fileName.getSize() > uploadMaxSize) {
            throw new FileSizeException("上传附件失败! 不允许上传超过" + uploadMaxSize / 1024 + "KB的文件!");
        }
        // 检查上传的文件类型
//        if (!contentTypes.contains(fileName.getContentType())) {
//            throw new FileTypeException("上传附件失败! 允许上传的附件类型有:" + contentTypes);
//        }
        String url=ossService.uploadFileAvatar(fileName);
        tbidder.setFile(url);
        service.register(tbidder);
        return R.ok();
    }

    @PostMapping("login")
    public R<Tbidder> login(String username, String password, HttpSession session) {
        // 调用service的login()进行登录
        Tbidder tbidder = service.login(username, password);
        
        // 向session中添加uid
        session.setAttribute("id", tbidder.getId());
        // 向session中添加contactsName
        session.setAttribute("username", tbidder.getContactsName());
        // 向session中添加contactsName
        session.setAttribute("companyName",tbidder.getCompanyName());

        return R.ok(tbidder);
    }
}
