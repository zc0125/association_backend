package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.ClubDto;
import com.feng.entity.Club;
import com.feng.entity.Club;
import com.feng.vo.ClubInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component
public interface ClubMapper extends BaseMapper<Club> {

    /**
     * 根据关键词搜索协会信息
     * @param club
     * @return
     */
    List<ClubInfoVo> findClub(Club club);

    /**
     * 根据id获取协会信息
     * @param id
     * @return
     */
    ClubInfoVo getInfoById(Integer id);

    List<Club> selectAllInfo();

    /**
     * 根据学号查询社团
     * @param num
     * @return
     */
    List<ClubDto> selectClubByStudentNum(String num);
}
