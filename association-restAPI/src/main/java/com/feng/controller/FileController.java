package com.feng.controller;


import com.feng.dto.FileDto;
import com.feng.entity.File;
import com.feng.entity.ResponseResult;
import com.feng.service.FileService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/files")
@Api(tags = "文件管理系统前台文章接口")
public class FileController {
    @Autowired
private FileService fileService;


    @GetMapping
    @ApiOperation("根据条件分页查询     所有文件")
    public ResponseResult list(File search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        PageInfo<FileDto> filePageInfo = fileService.getPage(pageNum,pageSize,search);
        return ResponseResultUtil.renderSuccess(filePageInfo);
    }


}

