package com.tl.eduservice.service;

import com.tl.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tl.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();

}
