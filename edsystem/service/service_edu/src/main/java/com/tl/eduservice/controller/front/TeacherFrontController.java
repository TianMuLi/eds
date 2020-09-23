package com.tl.eduservice.controller.front;/*
 *@Author lee
 * @date 2020/08/06
 */

import com.tl.commonutils.R;
import com.tl.eduservice.entity.EduCourse;
import com.tl.eduservice.entity.EduTeacher;
import com.tl.eduservice.service.EduCourseService;
import com.tl.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/teacherfront")
@CrossOrigin
public class TeacherFrontController {

    @Autowired
    private EduTeacherService teacherService;
    @Autowired
    private EduCourseService courseService;

    @PostMapping("getTeacherList/{page}/{limit}")
    public R getTeacherList(@PathVariable long page,@PathVariable long limit){
        Page<EduTeacher> pageteacher = new Page<>(page, limit);
        Map<String ,Object> map= teacherService.getTeacherList(pageteacher);
        return R.ok().data(map);
    }
    @GetMapping("getTeacherInfo/{teacherId}")
    public  R getTeacherInfo(@PathVariable String teacherId){
        EduTeacher teacher = teacherService.getById(teacherId);

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",teacherId);
        List<EduCourse> list = courseService.list(wrapper);

        return R.ok().data("teacher",teacher).data("courseList",list);
    }
}
