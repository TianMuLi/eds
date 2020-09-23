package com.tl.servicebase.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tl
 * @Date 2020/9/16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class edsException extends RuntimeException{
    private Integer code;
    private String  msg;
}
