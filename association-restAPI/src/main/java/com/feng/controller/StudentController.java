package com.feng.controller;


import com.feng.dto.StudentDto;
import com.feng.dto.UserClubDto;
import com.feng.entity.ResponseResult;
import com.feng.entity.Student;
import com.feng.entity.User;
import com.feng.enums.ErrorEnum;
import com.feng.exception.BusinessException;
import com.feng.exception.ParamInvalidException;
import com.feng.service.RedisOperatorService;
import com.feng.service.StudentService;
import com.feng.service.StudentSessionService;
import com.feng.service.UserClubService;
import com.feng.util.CookieUtil;
import com.feng.util.ResponseResultUtil;
import com.feng.util.StudentTokenUtils;
import com.feng.util.UUIDUtil;
import com.feng.vo.ClubPageVo;
import com.feng.vo.LoginStudentVo;
import com.google.code.kaptcha.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/students")
@Api(tags = "学生用户接口")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserClubService userClubService;
    @Autowired
    private RedisOperatorService redisOperatorService;
    @Autowired
    private StudentSessionService studentSessionService;

    @PostMapping("/register")
    @ApiOperation("学生用户注册")
    public ResponseResult add(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        studentService.insert(student);
        return ResponseResultUtil.renderSuccess("添加用户成功");
    }

    @PostMapping("/login")
    @ApiOperation("学生用户登录")
    public ResponseResult login(@Valid @RequestBody LoginStudentVo studentVo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        String code = studentVo.getCode();
        String codeKey = CookieUtil.getCookie(request, Constants.KAPTCHA_SESSION_KEY);
        String katchaCode = (String) redisOperatorService.getValue(codeKey);
        log.info("{}", katchaCode);
        if (StringUtils.isEmpty(code) || !katchaCode.equals(code.trim())) {
            throw new BusinessException(ErrorEnum.USER_CODE_ERROR);
        }

        Student loginStudent = studentService.login(studentVo);
        String token = UUIDUtil.getUUID();
        //登录成功
        if (loginStudent != null) {
            studentSessionService.saveStudentSession(token, loginStudent.getNum());
        }
        return ResponseResultUtil.renderSuccess(token);
    }

    @GetMapping("/getUser")
    @ApiOperation("通过token获取一个用户")
    public ResponseResult getByToken(@RequestParam(defaultValue = "") String token) {
        String num = studentSessionService.getStudentNum(token);
       Student student = studentService.getStudentByNum(num);
        return ResponseResultUtil.renderSuccess(student);
    }

    @GetMapping("/club")
    @ApiOperation("根据学号查询所有社团")
    public ResponseResult list(@RequestParam(defaultValue = "")String userId) {
        List<UserClubDto> list = userClubService.selectClubByStudentNum(userId);
        return ResponseResultUtil.renderSuccess(list);
    }

    @GetMapping("/logout")
    @ApiOperation("用户退出接口")
    public ResponseResult logout(HttpServletRequest request) {
        String token = StudentTokenUtils.getUserToken(request);
        studentSessionService.removeStudentSession(token);
        return ResponseResultUtil.renderSuccess("成功退出系统！");
    }
}

