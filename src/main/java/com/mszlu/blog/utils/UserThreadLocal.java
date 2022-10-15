package com.mszlu.blog.utils;

import com.mszlu.blog.dao.pojo.SysUser;

import java.lang.ref.PhantomReference;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/15 15:50
 * @description：
 */
public class  UserThreadLocal {
    private UserThreadLocal(){}
    // 线程变量隔离

    private static final  ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();


    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }


    public static SysUser get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }

}
