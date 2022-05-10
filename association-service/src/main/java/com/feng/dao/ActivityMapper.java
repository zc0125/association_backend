package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.ActivityFileDto;
import com.feng.dto.ActivityDto;
import com.feng.entity.Activity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 根据搜索信息搜索活动信息
     * @param activity
     * @return
     */
    List<ActivityDto> findActivity(Activity activity);

    /**
     * 根据搜索信息搜索活动信息
     * @param activity
     * @return
     */
    List<ActivityDto> findActivityByClubId(Activity activity);

    /**
     * 根据id获取活动信息
     * @param id
     * @return
     */
    ActivityFileDto getInfoById(Integer id);

    /**
     * 添加信息
     * @param activity
     * @return
     */
    Integer add(Activity activity);

}
