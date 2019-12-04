package com.hand.hls.train.springbootdemoday01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户实体类
 */
@Setter
@Getter
public class User {
    @Min(value = 1001, message = "id最小值为1001")
    private Integer id; //用户的id
    @NotNull(message = "用户名不为空")
    private String username;//用户名
    @Min(value = 1, message = "年龄最小为1岁")
    @Max(value = 200, message = "年龄最大为200岁")
    private Integer age;//年龄
    private Date createTime;//创建时间
}
