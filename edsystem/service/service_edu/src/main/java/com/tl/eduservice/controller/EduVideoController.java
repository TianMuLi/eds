package com.tl.eduservice.controller;


import com.tl.commonutils.R;
import com.tl.eduservice.client.VodClient;
import com.tl.eduservice.entity.EduVideo;
import com.tl.eduservice.service.EduVideoService;
import com.tl.servicebase.exceptionhandler.edsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
@RestController
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;
    @Autowired
    private VodClient vodClient;

    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    @DeleteMapping("{videoId}")
    public R delete(@PathVariable String videoId){

        EduVideo eduVideo = eduVideoService.getById(videoId);
        String videoSourceId = eduVideo.getVideoSourceId();

        if (!StringUtils.isEmpty(videoSourceId)){
            R remove = vodClient.remove(eduVideo.getVideoSourceId());
            if (remove.getCode()==20001){
                throw new edsException(20001,"删除视频失败....熔断器");
            }
        }

        eduVideoService.removeById(videoId);
        return R.ok();
    }

    @GetMapping("GetVideo/{videoId}")
    public R GetVideo(@PathVariable String videoId){
        EduVideo eduVideo  = eduVideoService.getById(videoId);
        return R.ok().data("video",eduVideo);
    }

    @PostMapping("updateVideo")
    public R updateChapter(@RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }

}

