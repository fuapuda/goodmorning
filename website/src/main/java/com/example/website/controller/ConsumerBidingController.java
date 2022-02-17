package com.example.website.controller;

import com.example.website.entity.ConsumerBiding;
import com.example.website.ex.*;
import com.example.website.service.IConsumerBidingService;
import com.example.website.service.OssService;
import com.example.website.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("bidings")
public class ConsumerBidingController {
    @Autowired
    private OssService ossService;
    @Autowired
    IConsumerBidingService consumerBidingService;

    @Value("${project.fileupload.register-file.base-dir}")
    String uploadBaseDir;
    @Value("${project.fileupload.register-file.max-size}")
    long uploadMaxSize;
    @Value("${project-fileupload.register-file.content-types}")
    List<String> contentTypes;
    @PostMapping(value = "create")
    public R createBidInfo(MultipartFile fileName, String mbId, HttpSession session){
        System.out.println(fileName);
        // 检查上传的文件是否为空
        if (fileName.isEmpty()) {
            throw new FileEmptyException("上传附件失败! 请选择有效的附件!");
        }
        // 检查上传的文件大小
        if (fileName.getSize() > uploadMaxSize) {
            throw new FileSizeException("上传附件失败! 不允许上传超过" + uploadMaxSize / 1024 + "KB的文件!");
        }
        // 检查上传的文件类型
        if (!contentTypes.contains(fileName.getContentType())) {
            throw new FileTypeException("上传附件失败! 允许上传的附件类型有:" + contentTypes);
        }
        String url=ossService.uploadFileAvatar(fileName);
        ConsumerBiding consumerBiding = new ConsumerBiding();
        consumerBiding.setFile(url);
        consumerBiding.setMbId(mbId);
        consumerBiding.setCompanyName((String)session.getAttribute("companyName"));
        consumerBiding.setTbId((Integer) session.getAttribute("id"));
        consumerBiding.setUsername((String)session.getAttribute("username"));
        consumerBidingService.createConsumerBiding(consumerBiding);
        return R.ok();
    }
}
