package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.UserDto;
import com.feng.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    List<UserDto> selectAll();

    User selectUserById(Integer id);

    List<UserDto> findBySearch(String search);
}
