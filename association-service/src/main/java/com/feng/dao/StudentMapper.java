package com.feng.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.feng.dto.ClubDto;
import com.feng.dto.StudentDto;
import com.feng.entity.Club;
import com.feng.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Component
public interface StudentMapper extends BaseMapper<Student> {

 /* //内部方法说明
    //添加用户
    Integer insert(Student student);
    //根据主键修改,未标注属性不修改
    Integer updateById(Student student);
    //根据主键修改，未标注属性为null
    Integer updateAllColumnById(Student student);
    //根据主键删除
    Integer deleteById(String num);
    //根据条件删除
    Integer deleteByMap(Map map);
    //根据条件查询第一行
    Student selectOne(Student student);
    //根据天剑查询所有
    List<Student> selectByMap (Map map);
    //查询id列表
    List<Student> selectBatchIds (List<String> list);
*/


    List<Student> getStudentByNum(String num);
    List<StudentDto> selectStudentByClubId(StudentDto student);

    List<StudentDto> selectClubByStudentNum(String userId);

    List<Student> getByLogin(String account);

}
