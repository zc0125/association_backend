package com.feng.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.feng.dao.StudentMapper;
import com.feng.dto.StudentDto;
import com.feng.entity.Student;
import com.feng.enums.ErrorEnum;
import com.feng.exception.BusinessException;
import com.feng.service.StudentService;
import com.feng.vo.ClubInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student login(Student student) {
        List<Student> studentList = studentMapper.getByLogin(student.getNum());
        if (studentList.isEmpty()) {
            throw new BusinessException(ErrorEnum.USER_NAME_ERROR);
        }
        Student loginStudent = studentList.get(0);
        if (!loginStudent.getPassword().equals(student.getPassword())) {
            throw new BusinessException(ErrorEnum.USER_PASSWORD_ERROR);
        }
        return loginStudent;
    }

    public Student getStudentByNum(String num){
        List<Student> students = studentMapper.getStudentByNum(num);
        if (students.isEmpty()) {
            throw new BusinessException(ErrorEnum.USER_NAME_ERROR);
        }
        Student student = students.get(0);
        return student;
    }

    @Override
    public PageInfo<StudentDto> getPage(int pageNum, int pageSize, StudentDto search) {
        PageHelper.startPage(pageNum, pageSize);
        System.out.println(search.getUserClub());
        List<StudentDto> studentList = studentMapper.selectStudentByClubId(search);
        return new PageInfo<>(studentList);
    }

    public List<StudentDto> selectClubByStudentNum(String userId){
        return studentMapper.selectClubByStudentNum(userId);
    }
}
