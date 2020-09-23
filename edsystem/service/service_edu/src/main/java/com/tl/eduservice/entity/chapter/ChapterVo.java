package com.tl.eduservice.entity.chapter;
/**
 * @Author tl
 * @Date 2020/9/18
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo {

    private  String id;

    private  String  title;

    private List<VideoVo>  children=new ArrayList<>();

}
