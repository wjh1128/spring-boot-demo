package com.hand.hls.train.springbootdemoday01.service.impl;

import com.hand.hls.train.springbootdemoday01.entity.User;
import com.hand.hls.train.springbootdemoday01.mapper.IUserMapper;
import com.hand.hls.train.springbootdemoday01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int create(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }
}
