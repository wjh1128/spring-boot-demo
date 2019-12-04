package com.hand.hls.train.springbootdemoday01.service;

import com.hand.hls.train.springbootdemoday01.entity.User;

import java.util.List;


public interface IUserService {
    /**
     * 根据用户的id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 创建一个用户信息
     *
     * @param user
     * @return
     */
    int create(User user);

    /**
     * 更新用户的信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有的用户
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 根据用户的id来删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
