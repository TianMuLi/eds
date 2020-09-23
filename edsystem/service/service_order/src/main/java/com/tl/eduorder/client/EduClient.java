package com.tl.eduorder.client;


import com.tl.commonutils.orderVo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author tl
 * @Date 2020/9/22
 */
@Component
@FeignClient("service-edu")
public interface EduClient {
    @PostMapping("/eduservice/coursefront/GetCourseInfoOrder/{id}")
    public CourseWebVoOrder GetCourseInfoOrder(@PathVariable("id") String id);
}
