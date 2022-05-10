package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.FileDto;
import com.feng.entity.File;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 */
@Component
public interface FileMapper extends BaseMapper<File> {
    Integer save(File file);

    List<FileDto> findFile(File search);
}
