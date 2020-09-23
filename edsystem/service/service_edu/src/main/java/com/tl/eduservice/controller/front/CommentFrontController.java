package com.tl.eduservice.controller.front;/*
 *@Author lee
 * @date 2020/08/08
 */

import com.tl.commonutils.JwtUtils;
import com.tl.commonutils.R;
import com.tl.eduservice.client.UcentClient;
import com.tl.eduservice.entity.EduComment;
import com.tl.eduservice.entity.UcenterMemberPay;
import com.tl.eduservice.service.EduCommentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/eduservice/commentfront")
@CrossOrigin
public class CommentFrontController {

    @Autowired
    private EduCommentService commentService;

    @Autowired
    private UcentClient ucentClient;
    @PostMapping("getCommentList/{page}/{limit}/{courseId}")
    public R getTeacherList(@PathVariable long page,@PathVariable long limit,@PathVariable String courseId){
        Page<EduComment> pagecomment = new Page<>(page, limit);
        Map<String ,Object> map= commentService.getCommentList(pagecomment,courseId);
        return R.ok().data(map);
    }
    @PostMapping("addComment")
    public R addComment(@RequestBody EduComment eduComment, HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if(StringUtils.isEmpty(memberId)) {
            return R.error().code(28004).message("请登录");
        }
        UcenterMemberPay memberPay = ucentClient.getMemberInfoByid(memberId);
        eduComment.setMemberId(memberId);
        eduComment.setNickname(memberPay.getNickname());
        eduComment.setAvatar(memberPay.getAvatar());
        System.out.println(eduComment);
        commentService.save(eduComment);
        return R.ok();
    }

}
