package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.StudentDto;
import com.feng.dto.UserClubDto;
import com.feng.entity.UserClub;
import com.feng.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
@Component
public interface UserClubMapper extends BaseMapper<UserClub> {

    List<UserClubDto> selectClubByStudentNum(String userId);

}
