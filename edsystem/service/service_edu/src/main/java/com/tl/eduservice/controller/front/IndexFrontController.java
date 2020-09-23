package com.tl.eduservice.controller.front;
/**
 * @Author tl
 * @Date 2020/9/19
 */


import com.tl.commonutils.R;

import com.tl.eduservice.entity.EduCourse;
import com.tl.eduservice.entity.EduTeacher;
import com.tl.eduservice.service.EduCourseService;
import com.tl.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eduservice/indexfront")
@CrossOrigin
public class IndexFrontController {

    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("index")
    public R index(){

        List<EduCourse> list = courseService.listCourse();
        List<EduTeacher> eduTeachers = teacherService.listTeacher();
        return  R.ok().data("course",list).data("teacher",eduTeachers);
     }
}
