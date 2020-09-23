package com.tl.eduservice.client;
/**
 * @Author tl
 * @Date 2020/9/19
 */

import com.tl.eduservice.entity.UcenterMemberPay;
import org.springframework.stereotype.Component;

@Component
public class UcentFileDegradeFeignClient implements UcentClient{
    @Override
    public UcenterMemberPay getMemberInfoByid(String id) {

        return null;
    }

}
