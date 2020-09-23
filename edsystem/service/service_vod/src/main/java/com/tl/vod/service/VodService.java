package com.tl.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author tl
 * @Date 2020/9/19
 */
public interface VodService {
    String uploadVideo(MultipartFile file);

    void removeMoreVideo(List videoIdList);
}
