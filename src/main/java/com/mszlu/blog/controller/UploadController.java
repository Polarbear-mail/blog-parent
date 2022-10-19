package com.mszlu.blog.controller;

import com.mszlu.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.util.UUID;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/19 9:11
 * @description：
 */

@RestController
@RequestMapping("upload")
public class UploadController {

    @PostMapping
    public Result upload(@RequestParam("image")MultipartFile file){
        // 原始文件名称，比如AA.png
        String originalFilename = file.getOriginalFilename();
        // 切分标识符后面的字符，获取唯一文件名称
        String filename = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename,".");
        // 上传文件 上传到哪 七牛云
        return null;
    }

}
