package com.mszlu.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/9/27 11:02
 * @description：
 */

@Data
@AllArgsConstructor
public class Result {

    private  boolean success;
    private  int code;
    private  String msg;
    private Object data;
//返回成功信息
    public static Result success(Object data){
        return  new Result(true,200,"succes",data);
    }

//返回失败信息
    public static Result fail(int code,String msg){
        return new Result(false,code,msg,null);
    }

}
