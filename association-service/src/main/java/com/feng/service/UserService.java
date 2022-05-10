package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.dto.UserDto;
import com.feng.entity.User;
import com.feng.entity.UserRole;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 */
public interface UserService{
    PageInfo<UserDto> getUserPage(int num, int size, User search);

    User login(User user);

    List<User> getByAccount(String account);

    User add(User user);

    User updateUserById(User user);

    User getUserById(Integer id);

   void  DeleteById(Serializable id);

    User getOneByAccount(String account);

    User register(User user,String rePassWord);
}
