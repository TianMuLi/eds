package com.tl.eduservice.controller.front;

/**
 * @Author tl
 * @Date 2020/9/19
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tl.commonutils.JwtUtils;
import com.tl.commonutils.R;
import com.tl.commonutils.orderVo.CourseWebVoOrder;
import com.tl.eduservice.client.OrdersClient;
import com.tl.eduservice.entity.EduCourse;
import com.tl.eduservice.entity.chapter.ChapterVo;
import com.tl.eduservice.entity.frontVo.CourseFrontVo;
import com.tl.eduservice.entity.frontVo.CourseWebVo;
import com.tl.eduservice.service.EduChapterService;
import com.tl.eduservice.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/coursefront")
@CrossOrigin
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduChapterService chapterService;
    @Autowired
    private OrdersClient ordersClient;
    @PostMapping("getCourseList/{page}/{limit}")
    public R getCourseList(@PathVariable long page, @PathVariable long limit, @RequestBody(required = false) CourseFrontVo courseFrontVo){
        Page<EduCourse> pagecourse= new Page<>(page, limit);
        Map<String ,Object> map= courseService.getCourseList(pagecourse,courseFrontVo);
        return R.ok().data(map);
    }
    @GetMapping("getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId, HttpServletRequest request){
        if (JwtUtils.getMemberIdByJwtToken(request)==null||JwtUtils.getMemberIdByJwtToken(request)==""){
            return R.error().code(28004);
        }
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);
        List<ChapterVo> videoByCourseList = chapterService.getChapterVideoByCourseId(courseId);

        Boolean info = ordersClient.getOrderInfo(courseId, JwtUtils.getMemberIdByJwtToken(request));


        return R.ok().data("courseWebVo",courseWebVo).data("videoByCourseList",videoByCourseList).data("isBuy",info);
    }
    @PostMapping("GetCourseInfoOrder/{id}")
    public CourseWebVoOrder GetCourseInfoOrder(@PathVariable String id){
        CourseWebVo baseCourseInfo = courseService.getBaseCourseInfo(id);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(baseCourseInfo,courseWebVoOrder);
        return courseWebVoOrder;
    }
}
