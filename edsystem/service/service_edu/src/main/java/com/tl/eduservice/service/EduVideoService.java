package com.tl.eduservice.service;

import com.tl.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduVideoService extends IService<EduVideo> {
    void removeByCourseId(String courseId);
}
