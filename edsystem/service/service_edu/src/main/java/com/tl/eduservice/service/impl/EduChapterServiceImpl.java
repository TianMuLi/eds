package com.tl.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tl.eduservice.entity.EduChapter;
import com.tl.eduservice.entity.EduVideo;
import com.tl.eduservice.entity.chapter.ChapterVo;
import com.tl.eduservice.entity.chapter.VideoVo;
import com.tl.eduservice.mapper.EduChapterMapper;
import com.tl.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.eduservice.service.EduVideoService;
import com.tl.servicebase.exceptionhandler.edsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author tl
 * @since 2020-09-16
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {


    @Autowired
    private EduVideoService eduVideoService;
    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id",courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(wrapperChapter);

        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperChapter.eq("course_id",courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(wrapperVideo);

        List<ChapterVo> finalList=new ArrayList<>();
        for (int i = 0; i < eduChapterList.size(); i++) {
            EduChapter eduChapter = eduChapterList.get(i);
            ChapterVo chapterVo=new ChapterVo();
            BeanUtils.copyProperties(eduChapter,chapterVo);
            finalList.add(chapterVo);

            List<VideoVo> videoVos = new ArrayList<>();
            for (int j=0;j<eduVideoList.size();j++) {
                EduVideo eduVideo = eduVideoList.get(j);
                if (eduVideo.getChapterId().equals(eduChapter.getId())){
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo,videoVo);
                    videoVos.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVos);
        }
        return finalList;
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper<EduVideo> eduVideoQueryWrapper = new QueryWrapper<>();
        eduVideoQueryWrapper.eq("chapter_id",chapterId);
        int count = eduVideoService.count(eduVideoQueryWrapper);
        if (count>0){
            throw new edsException(20001,"该章节中含有内容不能删除！");
        }else {
            int i = baseMapper.deleteById(chapterId);
            return i>0;
        }
    }

    @Override
    public void removeByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
