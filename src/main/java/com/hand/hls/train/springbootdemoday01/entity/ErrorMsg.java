package com.hand.hls.train.springbootdemoday01.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.BindingResult;

/**
 * 作为错误信息类
 */
@Setter
@Getter
public class ErrorMsg {
    private String message;//错误的消息

    public void setMessage(String str) {
        this.message = str;
    }

    //重写了message
    public void setMessage(BindingResult result) {
        this.message = result.getAllErrors().get(0).getDefaultMessage();
    }
}
