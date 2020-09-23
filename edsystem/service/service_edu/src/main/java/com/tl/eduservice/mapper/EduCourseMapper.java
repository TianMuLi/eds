package com.tl.eduservice.mapper;

import com.tl.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tl.eduservice.entity.frontVo.CourseWebVo;
import com.tl.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getCoursePublishVo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}
