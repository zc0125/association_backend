package com.feng.service;

/**
 * 使用redis保存用户登录会话信息
 */
public interface StudentSessionService {
    void saveStudentSession(String token,String studentNum);

    String getStudentNum(String token);

    void removeStudentSession(String token);

    void updateStudentSession(String token);

    boolean isStudentTokenExist(String token);
}
