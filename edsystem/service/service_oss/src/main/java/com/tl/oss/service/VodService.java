package com.tl.oss.service;

/**
 * @Author tl
 * @Date 2020/9/20
 */

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    String uploadVideo(MultipartFile file);
}
