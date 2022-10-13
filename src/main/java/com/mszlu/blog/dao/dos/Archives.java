package com.mszlu.blog.dao.dos;

import lombok.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/13 9:23
 * @description：
 */
@Data
public class Archives {
    private Integer year;
    private  Integer month;
    private  Long count;
}
