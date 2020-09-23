package com.tl.eduorder.controller;


import com.tl.commonutils.R;
import com.tl.eduorder.service.TPayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/eduorder/t-pay-log")
@CrossOrigin
public class TPayLogController {

    @Autowired
    private TPayLogService payLogService;

    @GetMapping("createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo){
        Map map= payLogService.createNative(orderNo);
        System.out.println("返回的二维码集合："+map);
        return  R.ok().data("map",map);
    }
    @GetMapping("queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo){
        Map<String ,String> map=payLogService.queryPayStatus(orderNo);
        System.out.println("查询订单状态的的集合："+map);
        if (map==null){
            return R.error().message("支付出错");
        }
        if (map.get("trade_state").equals("SUCCESS")){
            payLogService.updateOrderStatus(map);
            return R.ok().message("支付成功");
        }
        return R.ok().code(25000).message("支付中");
    }

}

