package edu.dhu.mooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class IndexController {
    @GetMapping(path = {"","/"})
    public ModelAndView getIndexPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        Object user =  request.getSession().getAttribute("user");
        if (user == null) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("page/index");
            mv.addObject(user);
        }
        return mv;
    }
}
