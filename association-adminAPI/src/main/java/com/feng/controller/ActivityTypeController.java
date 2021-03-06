package com.feng.controller;


import com.feng.entity.ActivityType;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ActivityTypeService;
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
 */
@RestController
@RequestMapping("/activityTypes")
@Api(value = "社团管理系统后台活动类型管理接口",tags = "社团管理系统后台活动类型管理接口")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;

    @GetMapping
    @ApiOperation(value = "查找所有活动类型",notes = "查找所有活动类型")
    public ResponseResult list() {
        List<ActivityType> activityTypeList = activityTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(activityTypeList);
    }

    @ApiOperation(value = "通过id获取一个活动类型",notes = "通过id获取一个活动类型")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        ActivityType activityType = activityTypeService.selectById(id);
        return ResponseResultUtil.renderSuccess(activityType);
    }

    @PutMapping
    @ApiOperation(value = "更新活动类型",notes = "更新活动类型")
    public ResponseResult edit(@Valid @RequestBody ActivityType activityType , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityTypeService.updateById(activityType);
        return ResponseResultUtil.renderSuccess("更新成功");
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "根据id删除活动类型",notes = "根据id删除活动类型")
    public ResponseResult delete( @PathVariable Integer id) {
        activityTypeService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除活动类型成功");
    }

    @PostMapping
    @ApiOperation(value = "添加活动类型",notes = "添加活动类型")
    public ResponseResult add(@Valid @RequestBody ActivityType activityType , BindingResult bindingResult) {
        System.out.println("**********************************************");
        System.out.println(activityType.getType());
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        System.out.println(activityType.getType());
        activityTypeService.insert(activityType);
        return ResponseResultUtil.renderSuccess("添加活动类型成功");
    }
}

