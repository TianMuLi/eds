package com.tl.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduTeacherService extends IService<EduTeacher> {

    List<EduTeacher> listTeacher();

    Map<String, Object> getTeacherList(Page<EduTeacher> pageteacher);

}
