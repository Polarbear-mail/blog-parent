package com.mszlu.blog.vo;

import lombok.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/10/14 13:28
 * @description：
 */
@Data
public class LoginUserVo {

    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}
