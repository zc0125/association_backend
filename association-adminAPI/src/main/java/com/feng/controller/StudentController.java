package com.feng.controller;


import com.feng.dto.StudentDto;
import com.feng.entity.Club;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ClubService;
import com.feng.service.StudentService;
import com.feng.service.UserClubService;
import com.feng.util.ResponseResultUtil;
import com.feng.vo.ClubInfoVo;
import com.github.pagehelper.PageInfo;
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
@CrossOrigin
@RequestMapping("/students")
@Api(value = "学生信息管理接口",tags = "学生信息管理接口")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserClubService userClubService;

//    @ApiOperation("通过社团编号num查看一个社团")
//    @GetMapping("/{num}")
//    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
//        Club club = clubService.getById(num);
//        return ResponseResultUtil.renderSuccess(club);
//    }

//    @ApiOperation("查询所有社团")
//    @GetMapping("/list")
//    public ResponseResult allList() {
//        List clubInfos = clubService.getAllInfo();
//        return ResponseResultUtil.renderSuccess(clubInfos);
//    }

    @ApiOperation("根据社团num条件分页查询学生")
    @GetMapping
    public ResponseResult list(StudentDto search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<StudentDto> studentPageInfo = studentService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(studentPageInfo);
    }

    @ApiOperation("通过id删除一个加入社团记录")
    @DeleteMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        userClubService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }
//
//    @ApiOperation("添加一个社团")
//    @PostMapping
//    public ResponseResult add(@Valid @RequestBody Club club, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String msg = bindingResult.getFieldError().getDefaultMessage();
//            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
//        }
//        clubService.add(club);
//        return ResponseResultUtil.renderSuccess("添加社团成功");
//    }
//
//    @ApiOperation("通过id更新一个社团")
//    @PutMapping
//    public ResponseResult update(@RequestBody @Valid Club club, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String msg = bindingResult.getFieldError().getDefaultMessage();
//            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
//        }
//        clubService.updateWithId(club);
//        return ResponseResultUtil.renderSuccess("更新社团成功");
//    }
}

