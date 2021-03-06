package com.feng.controller;

import com.feng.entity.ResponseResult;
import com.feng.util.ResponseResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by zhang.
 */
@RestController
@RequestMapping("/system")
@ApiIgnore
public class SystemController {
    @Value("${system.adminIndex}login")
    private String accessAdminUrl;

    @GetMapping("/adminUrl")
    public ResponseResult getAccessAdminUrl() {
        return ResponseResultUtil.renderSuccess(accessAdminUrl);
    }
}
