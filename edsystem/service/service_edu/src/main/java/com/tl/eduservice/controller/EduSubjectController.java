package com.tl.eduservice.controller;


import com.tl.commonutils.R;
import com.tl.eduservice.entity.subject.OneSubject;
import com.tl.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
@RestController
@RequestMapping("/eduservice/edu-subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }

    //列表显示（树形）
    @GetMapping("getAllSubject")
    public R getAllSubject(){

        List<OneSubject> list= eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }

}

