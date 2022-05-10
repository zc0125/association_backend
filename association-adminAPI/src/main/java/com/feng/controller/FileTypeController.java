package com.feng.controller;


import com.feng.entity.FileType;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.FileTypeService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/fileTypes")
@Api(value = "社团管理系统后台文件类型管理接口",tags = "社团管理系统后台文件类型管理接口")
public class FileTypeController {
    @Autowired
    private FileTypeService fileTypeService;

    @GetMapping
    @ApiOperation("查找所有文件类型")
    public ResponseResult list() {
        List<FileType> fileTypeList = fileTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(fileTypeList);
    }

    @ApiOperation("通过id获取一个文件类型")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        FileType fileType = fileTypeService.selectById(id);
        return ResponseResultUtil.renderSuccess(fileType);
    }

    @PutMapping
    @ApiOperation("更新文件类型")
    public ResponseResult edit(@Valid @RequestBody FileType fileType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        fileTypeService.updateById(fileType);
        return ResponseResultUtil.renderSuccess("更新成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除文件类型")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        fileTypeService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除文件类型成功");
    }

    @PostMapping
    @ApiOperation("添加文件类型")
    public ResponseResult add(@Valid @RequestBody FileType fileType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        fileTypeService.insert(fileType);
        return ResponseResultUtil.renderSuccess("添加文件类型成功");
    }
}

