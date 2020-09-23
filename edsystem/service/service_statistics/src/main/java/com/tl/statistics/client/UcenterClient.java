package com.tl.statistics.client;
/**
 * @Author tl
 * @Date 2020/9/19
 */

import com.tl.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    @GetMapping("/ucenterservice/ucenter-member/countRegister/{day}")
    public R countRegister(@PathVariable("day") String day);
}
