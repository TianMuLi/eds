package com.tl.oss.service;
/**
 * @Author tl
 * @Date 2020/9/20
 */

import org.springframework.web.multipart.MultipartFile;


public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
