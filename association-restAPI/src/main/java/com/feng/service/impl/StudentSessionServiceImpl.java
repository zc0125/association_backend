package com.feng.service.impl;

import com.feng.constants.AppConstant;
import com.feng.service.RedisOperatorService;
import com.feng.service.StudentSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentSessionServiceImpl implements StudentSessionService {
    @Autowired
    private RedisOperatorService redisOperatorService;
    private String studentTokenPrefix = AppConstant.studentTokenPrefix;
    private int sessionTime = AppConstant.loginTokenTime;

    @Override
    public void saveStudentSession(String token, String studentNum) {
        redisOperatorService.setValue(studentTokenPrefix + token, studentNum+"", sessionTime);
    }

    @Override
    public String getStudentNum(String token) {
      String userIdStr =  redisOperatorService.getValue(studentTokenPrefix+token);
      String userId="";
      if(!StringUtils.isEmpty(userIdStr)){
          userId=userIdStr;
      }
        return userId;
    }

    @Override
    public void removeStudentSession(String token) {
        redisOperatorService.deleteKey(studentTokenPrefix + token);
    }

    @Override
    public void updateStudentSession(String token) {
        redisOperatorService.expireKey(studentTokenPrefix + token, sessionTime);
    }
    @Override
    public boolean isStudentTokenExist(String token) {
        return redisOperatorService.isExists(studentTokenPrefix + token);
    }
}
