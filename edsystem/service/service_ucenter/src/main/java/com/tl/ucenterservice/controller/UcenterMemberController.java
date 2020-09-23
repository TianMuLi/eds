package com.tl.ucenterservice.controller;


import com.tl.commonutils.JwtUtils;
import com.tl.commonutils.R;
import com.tl.commonutils.orderVo.UcenterMemberOrder;
import com.tl.ucenterservice.entity.UcenterMember;
import com.tl.ucenterservice.entity.vo.RegisterVo;
import com.tl.ucenterservice.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-21
 */
@RestController
@RequestMapping("/ucenterservice/ucenter-member")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member){

        String token=  ucenterMemberService.login(member);
        return R.ok().data("token",token);
    }
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo){

        ucenterMemberService.register(registerVo);
        return  R.ok();
    }
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String jwtToken = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = ucenterMemberService.getById(jwtToken);
        return R.ok().data("userInfo",member);
    }
    @GetMapping("getMemberInfoByid/{id}")
    public UcenterMember getMemberInfoByid(@PathVariable String id){
        UcenterMember member = ucenterMemberService.getById(id);
        return member;
    }
    @PostMapping("getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id){
        UcenterMember memberServiceById = ucenterMemberService.getById(id);
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(memberServiceById,ucenterMemberOrder);
        return ucenterMemberOrder;
    }
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day){
        Integer count  =ucenterMemberService.countRegisterDay(day);
        return R.ok().data("countRegister",count);
    }
}

