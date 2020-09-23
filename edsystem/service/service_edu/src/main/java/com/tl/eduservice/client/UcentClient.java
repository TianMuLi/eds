package com.tl.eduservice.client;/*
 *@Author lee
 * @date 2020/08/08
 */

import com.tl.eduservice.entity.UcenterMemberPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-ucenter",fallback =UcentFileDegradeFeignClient.class )
@Component
public interface UcentClient {

    @GetMapping("/ucenterservice/ucenter-member/getMemberInfoByid/{id}")
    public UcenterMemberPay getMemberInfoByid(@PathVariable("id") String id);
}
