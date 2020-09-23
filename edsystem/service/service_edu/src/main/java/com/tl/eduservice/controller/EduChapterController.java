package com.tl.eduservice.controller;



import com.tl.commonutils.R;
import com.tl.eduservice.entity.EduChapter;
import com.tl.eduservice.entity.chapter.ChapterVo;
import com.tl.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
@RestController
@RequestMapping("/eduservice/edu-chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> list= eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("list",list);
    }
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return R.ok();
    }
    @GetMapping("GetChapter/{chapterId}")
    public R GetChapter(@PathVariable String chapterId){
        EduChapter eduChapter = eduChapterService.getById(chapterId);
        return R.ok().data("chapter",eduChapter);
    }
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return R.ok();
    }
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        boolean b = eduChapterService.deleteChapter(chapterId);
        return R.ok();
    }

}

