package edu.dhu.mooc.controller;

import edu.dhu.mooc.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xieyiming
 * @description: 设置首页信息
 * @createTime: 2021-03-19
 */
@RestController
@Slf4j
@Api("用于跳转首页的Controller")
public class IndexController {

    @ApiOperation("给前端的窗口相应session中的user对象")
    @GetMapping(path = {"","/","/index.html"})
    public User getIndexPage(HttpServletRequest request){
        //通过session对象来获取User中的信息身份。然后相应对应的页面
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }
}
