package com.octv.im.service;

import com.octv.im.entity.vo.FileItemVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    /**
     * 上传文件到服务器中
     * @param file
     * @param type
     * @return
     */
    FileItemVO uploadFile(MultipartFile file, Integer type);

    /**
     * 下载文件
     * @param fileId
     * @param response
     */
    void downloadFile(Integer fileId, HttpServletResponse response);

    /**
     * 删除文件
     * @param fileId
     */
    void deleteFile(Long fileId);

}
