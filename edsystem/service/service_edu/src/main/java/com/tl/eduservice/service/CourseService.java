package com.tl.eduservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.eduservice.entity.vo.CoursePublishVo;
import com.tl.eduservice.entity.vo.CourseQuery;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-07-27
 */
public interface CourseService extends IService<CoursePublishVo> {


    List<CoursePublishVo> findResultByInfo(CourseQuery courseQuery);

    Integer totals(CourseQuery courseQuery);


}
