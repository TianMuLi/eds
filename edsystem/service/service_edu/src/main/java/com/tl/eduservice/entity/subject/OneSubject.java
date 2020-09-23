package com.tl.eduservice.entity.subject;

/**
 * @Author tl
 * @Date   2020/9/18
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneSubject {

    private String  id;
    private String  title;

    private List<TwoSubject> children=new ArrayList<>();
}
