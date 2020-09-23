package com.tl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.eduservice.entity.EduComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduCommentService extends IService<EduComment> {
    Map<String, Object> getCommentList(Page<EduComment> pagecomment, String courseId);
}
