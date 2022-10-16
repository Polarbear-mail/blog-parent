package com.mszlu.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mszlu.blog.dao.pojo.SysUser;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class CommentVo  {

    // 防止雪花算法精度损失，把id转化为String
    //防止前端 精度损失 把id转为string
    // 分布式id 比较长，传到前端 会有精度损失，必须转为string类型 进行传输，就不会有问题了
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;
}
