package com.mszlu.blog.handler;

import com.mszlu.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/12 14:50
 * @description：
 */
// 对加了controller的异常进行处理 AOP
@ControllerAdvice
public class AllExceptionHandler {
    // 进行异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody // 返回json 数据，不加则返回页面
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-999,"系统异常");
    }

}
