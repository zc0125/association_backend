package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.PassageDto;
import com.feng.dto.PassageFileDto;
import com.feng.entity.Passage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 */
@Component
public interface PassageMapper extends BaseMapper<Passage> {
    List<PassageDto> findPassage(Passage passage);

    List<PassageDto> findPassageByClubId(Passage passage);

    PassageFileDto getInfoById(Integer id);

    Passage findSimplePassage(Passage passage);

    int add(Passage passage);
}
