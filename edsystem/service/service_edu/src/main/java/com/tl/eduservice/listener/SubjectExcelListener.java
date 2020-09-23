package com.tl.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tl.eduservice.entity.EduSubject;
import com.tl.eduservice.entity.excel.SubjectData;
import com.tl.eduservice.service.EduSubjectService;
import com.tl.servicebase.exceptionhandler.edsException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {


    public EduSubjectService eduSubjectService;
    public SubjectExcelListener() {}
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

        if (subjectData==null){
            throw  new edsException(20001,"文件数据为空");
        }
        EduSubject eduOneSubject = this.exitOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if(eduOneSubject==null){
            eduOneSubject = new EduSubject();
            eduOneSubject.setParentId("0");
            eduOneSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(eduOneSubject);
        }
        EduSubject exitTwoSubject = this.exitTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), eduOneSubject.getId());
        if(exitTwoSubject==null){
            exitTwoSubject = new EduSubject();
            exitTwoSubject.setParentId(eduOneSubject.getId());
            exitTwoSubject.setTitle(subjectData.getTwoSubjectName());
            eduSubjectService.save(exitTwoSubject);
        }
    }


    //判断一级分类不能重复添加
    private EduSubject exitOneSubject(EduSubjectService subjectService ,String name){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject one = subjectService.getOne(wrapper);
        return one;
    }

    //判断二级分类不能重复添加
    private EduSubject exitTwoSubject(EduSubjectService subjectService ,String name,String pid){
        QueryWrapper<EduSubject> wrapper=new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject two = subjectService.getOne(wrapper);
        return two;
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
