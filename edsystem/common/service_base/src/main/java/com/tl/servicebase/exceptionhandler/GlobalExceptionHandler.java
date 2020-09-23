package com.tl.servicebase.exceptionhandler;

import com.tl.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author tl
 * @Date 2020/9/17
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理...");
    }


    @ExceptionHandler(edsException.class)
    @ResponseBody
    public R error(edsException e){
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
