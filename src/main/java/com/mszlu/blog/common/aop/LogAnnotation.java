package com.mszlu.blog.common.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

//  Type 代表可以放在类上面Method 代表可以放在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Controller
//@ResponseBody
public @interface LogAnnotation {

    String module() default "";
    String operater() default "";

}
