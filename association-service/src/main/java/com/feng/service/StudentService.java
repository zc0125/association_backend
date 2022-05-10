package com.feng.service;

import com.baomidou.mybatisplus.service.IService;
import com.feng.dto.StudentDto;
import com.feng.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface StudentService extends IService<Student> {

    Student login(Student student);

    Student getStudentByNum(String num);

    PageInfo<StudentDto> getPage(int pageNum, int pageSize, StudentDto search);

    List<StudentDto> selectClubByStudentNum(String userId);
}
