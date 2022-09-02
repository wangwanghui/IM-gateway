package com.octv.im.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileItemVO {
    /**
     * 文件id
     */
    private Long fileId;

    /**
     * 文件可访问URL
     */
    private String url;

    /**
     * 文件的拓展名
     */
    private String ext;

    /**
     * 上传的源文件的文件名，带有拓展
     */
    private String fileName;

    /**
     * 上传后的文件名
     */
    private String newFileName;


}
