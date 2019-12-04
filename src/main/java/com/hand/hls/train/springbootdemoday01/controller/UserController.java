package com.hand.hls.train.springbootdemoday01.controller;

import com.hand.hls.train.springbootdemoday01.entity.ErrorMsg;
import com.hand.hls.train.springbootdemoday01.entity.User;
import com.hand.hls.train.springbootdemoday01.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        if (id == null) {
            ErrorMsg errMsg = new ErrorMsg();
            errMsg.setMessage("用户的id不能为空");
            throw new IllegalArgumentException(errMsg.getMessage());
        }
        User user = userService.getUserById(id);
        if (user == null) {
            throw new IllegalArgumentException("暂无该用户信息");
        }
        return user;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.selectAll();
    }

    @PostMapping("/create")
    @Transactional(rollbackFor = Exception.class)
    public User createUser(@RequestBody @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ErrorMsg errorMsg = new ErrorMsg();
            errorMsg.setMessage(bindingResult);
            throw new IllegalArgumentException(errorMsg.getMessage());
        }
        int result = userService.create(user);
        if (result > 0) {
            return user;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete{id}")
    @Transactional(rollbackFor = Exception.class)
    public String deleteUserById(@PathVariable("id") Integer id) {
        if (id == null) {
            ErrorMsg errMsg = new ErrorMsg();
            errMsg.setMessage("用户的id不能为空");
            throw new IllegalArgumentException(errMsg.getMessage());
        }
        return "success";
    }

    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (user.getId() == null) {
            ErrorMsg errMsg = new ErrorMsg();
            errMsg.setMessage("用户的id不能为空");
            throw new IllegalArgumentException(errMsg.getMessage());
        }
        if (bindingResult.hasErrors()) {
            ErrorMsg errorMsg = new ErrorMsg();
            errorMsg.setMessage(bindingResult);
            throw new IllegalArgumentException(errorMsg.getMessage());
        }
        userService.updateUser(user);
        return user;
    }
}
