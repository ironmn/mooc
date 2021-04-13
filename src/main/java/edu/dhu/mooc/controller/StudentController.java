package edu.dhu.mooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/19 17:58
 * @describe 学生的信息管理界面
 */
@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/front-page")
    public ModelAndView jumpToFrontPage(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
