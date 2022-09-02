package com.octv.im.controller;

import com.octv.im.entity.vo.FileItemVO;
import com.octv.im.service.FileService;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private FileService fileService;


    //查询某个聊天室的消息历史记录
    @GetMapping(value = "/A")
    public String getGroupMessageHistory() {
        System.out.println("test");
        return "success";
    }

    @PostMapping("/upload")
    public String upload(@NotNull @RequestParam(value = "file") MultipartFile file, @NotNull @RequestParam(value = "type") Integer type) {
        try {
            FileItemVO fileItemVO = fileService.uploadFile(file, type);
            System.out.println(fileItemVO.getFileId());
        } catch (Exception e) {
            log.error("error",e);
        }
        return "success";
    }

}
