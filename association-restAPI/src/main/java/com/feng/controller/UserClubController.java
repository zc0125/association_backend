package com.feng.controller;


import com.feng.entity.ResponseResult;
import com.feng.entity.UserClub;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserClubService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userClub")
@Api(tags = "学生社团管理接口")
public class UserClubController {

    @Autowired
    private UserClubService userClubService;

    @PostMapping
    @ApiOperation("申请加入社团")
    public ResponseResult add(@Valid @RequestBody UserClub userClub, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",userClub.getUserId());
        map.put("club_id",userClub.getClubId());
        List<UserClub> list = userClubService.selectByMap(map);
        if(list != null && list.size() > 0){
            return ResponseResultUtil.renderError(201,"已经加入该社团");
        }
        userClubService.insert(userClub);
        return ResponseResultUtil.renderSuccess("加入社团成功");
    }
}
