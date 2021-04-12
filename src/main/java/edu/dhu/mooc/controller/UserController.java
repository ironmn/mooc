package edu.dhu.mooc.controller;


import edu.dhu.mooc.entity.LoginInfo;
import edu.dhu.mooc.entity.User;
import edu.dhu.mooc.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : xieyiming
 * @date:2021-03-14
 * @describe: 处理用户的登录请求
 */
@RestController
@Slf4j
@Api
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录校验")
    public LoginInfo login(@RequestBody User user, HttpServletRequest request){
        LoginInfo loginInfo = new LoginInfo();
        if(loginService.hasAccount(user)){
            loginInfo.setInfo("success");
            loginInfo.setRole(user.getRole());
            loginInfo.setId(loginService.findIdByUser(user));
        }
        else{
            loginInfo.setInfo("failed");
        }
        return loginInfo;
    }

    @PostMapping("/register")
    @ApiOperation("注册用户")
    public String register(@RequestBody User user,HttpServletRequest request){
        String register_phone = user.getPhone();
        if(!loginService.checkIfPhoneValid(register_phone)){
            return "failed";
        }
        else {
            if(user.getRole() == null || user.getGender() == null) return "failed";
            loginService.insertUser(user);
            return "success";
        }
    }
}
