package com.tl.eduorder.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tl.commonutils.JwtUtils;
import com.tl.commonutils.R;
import com.tl.eduorder.entity.TOrder;
import com.tl.eduorder.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/eduorder/t-order")
@CrossOrigin
public class TOrderController {
    @Autowired
    private TOrderService orderService;

    @PostMapping("createOrder/{courseId}")
    public R createOrder(@PathVariable String courseId, HttpServletRequest request){
        System.out.println("======================"+ JwtUtils.getMemberIdByJwtToken(request));
        if (JwtUtils.getMemberIdByJwtToken(request)==null||JwtUtils.getMemberIdByJwtToken(request)==""){
            return R.error().code(28004);
        }
        String  orderNo= orderService.createOrder(courseId, JwtUtils.getMemberIdByJwtToken(request));

        return R.ok().data("orderId",orderNo);
    }
    //根据订单id查询订单信息
    @GetMapping("getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable String orderId){
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderId);
        TOrder order = orderService.getOne(wrapper);

        return R.ok().data("order",order);
    }
    @GetMapping("IsBuyCourse/{orderId}/{memberId}")
    public Boolean getOrderInfo(@PathVariable String orderId, @PathVariable String memberId){
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",orderId);
        wrapper.eq("member_id",memberId);
        wrapper.eq("status",1);
        int count= orderService.count(wrapper);
        if (count>0){
            return true;
        }else {
            return false;
        }

    }

}

