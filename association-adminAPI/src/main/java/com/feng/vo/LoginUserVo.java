package com.feng.vo;

import com.feng.entity.User;
import lombok.Data;

/**
 * Created by zhang.
 */
@Data
public class LoginUserVo extends User{
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
