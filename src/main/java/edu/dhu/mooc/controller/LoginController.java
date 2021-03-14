package edu.dhu.mooc.controller;


import edu.dhu.mooc.entity.User;
import edu.dhu.mooc.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author : xieyiming
 * @date:2021-03-14
 * @describe: 处理用户的登录请求
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request,
                              HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        if(loginService.hasAccount(user)){
            mv.setViewName("redirect:/");
            request.getSession().setAttribute("user", user);
        }
        else{
            mv.addObject("err_info","用户名或密码错误");
            mv.setViewName("page/login");
        }
        return mv;
    }

    @GetMapping("/login")
    public String login(){
        return "page/login";
    }
}
