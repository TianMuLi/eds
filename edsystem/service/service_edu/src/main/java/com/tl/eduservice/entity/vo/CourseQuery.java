package com.tl.eduservice.entity.vo;



import lombok.Data;

import java.io.Serializable;


@Data
public class CourseQuery implements Serializable {


    private String title;

    private String status;

    private Integer pageNumber;

    private Integer pageSize;

    public CourseQuery() {
    }

    public CourseQuery(String title, String status, Integer pageNumber, Integer pageSize) {
        this.title = title;
        this.status = status;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
