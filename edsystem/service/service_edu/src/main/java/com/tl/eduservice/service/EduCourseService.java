package com.tl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.eduservice.entity.frontVo.CourseFrontVo;
import com.tl.eduservice.entity.frontVo.CourseWebVo;
import com.tl.eduservice.entity.vo.CourseInfoVo;
import com.tl.eduservice.entity.vo.CoursePublishVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduCourseService extends IService<EduCourse> {
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getPublishCourse(String courseId);

    void deleteCourse(String courseId);


    List<EduCourse> listCourse();

    Map<String, Object> getCourseList(Page<EduCourse> pagecourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
