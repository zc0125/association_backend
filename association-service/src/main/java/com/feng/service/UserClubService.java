package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.dto.UserClubDto;
import com.feng.entity.UserClub;
import com.feng.entity.UserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface UserClubService extends IService<UserClub> {

    List<UserClubDto> selectClubByStudentNum(String userId);

}
