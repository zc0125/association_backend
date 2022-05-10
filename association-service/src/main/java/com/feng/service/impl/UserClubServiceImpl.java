package com.feng.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.UserClubMapper;
import com.feng.dao.UserRoleMapper;
import com.feng.dto.UserClubDto;
import com.feng.entity.UserClub;
import com.feng.entity.UserRole;
import com.feng.service.UserClubService;
import com.feng.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserClubServiceImpl extends ServiceImpl<UserClubMapper, UserClub> implements UserClubService {

    @Autowired
    private UserClubMapper userClubMapper;
    @Override
    public List<UserClubDto> selectClubByStudentNum(String userId) {
        return userClubMapper.selectClubByStudentNum(userId);
    }
}
