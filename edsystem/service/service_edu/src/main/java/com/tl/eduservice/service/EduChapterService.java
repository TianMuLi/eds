package com.tl.eduservice.service;

import com.tl.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduChapterService extends IService<EduChapter> {
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeByCourseId(String courseId);
}
