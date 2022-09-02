package com.octv.im.service.impl;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.octv.im.entity.vo.FileItemVO;
import com.octv.im.service.FileService;
import com.octv.im.util.MinioUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.entity.FileEntity;
import org.slf4j.Marker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class FileItemServiceImpl implements FileService {
    @Resource
    private MinioUtil minioUtil;

    @Value("${minio.bucketName}")
    private String bucketName;


    private String[] fileFolders = new String[]{"doctorPhotos/", "report", "otherImage/","video/"};

    @Override
    public FileItemVO uploadFile(MultipartFile file, Integer type) {
        FileItemVO fileItemVO = null;
        Date start = new Date();
        try {
            String fileName = file.getOriginalFilename();
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = fileFolders[type] + UUID.randomUUID().toString().replaceAll("-", "") + ext;
            fileItemVO.setFileName(newFileName);
            fileItemVO.setExt(ext);
            InputStream inputStream = file.getInputStream();
            Boolean flag = minioUtil.upload(bucketName, newFileName,file, inputStream);
            Date end = new Date();
            log.debug("文件上传状态 {} 耗时 {} ",flag,end.getTime() - start.getTime());
            if(!flag) {
                throw new Exception("文件上传失败");
            }
        } catch (Exception e) {
            log.error((Marker) e,"文件上传失败");
        }
        return fileItemVO;
    }

    @Override
    public void downloadFile(Integer fileId, HttpServletResponse response) {

    }

    @Override
    public void deleteFile(Long fileId) {

    }


}
