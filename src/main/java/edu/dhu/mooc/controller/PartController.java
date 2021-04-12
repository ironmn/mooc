package edu.dhu.mooc.controller;

import edu.dhu.mooc.service.PartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:06
 * @describe 进行章节的判断
 */

@RestController
@RequestMapping("/part")
@Api("处理与章节相关的业务")
@Slf4j
public class PartController {

    @Autowired
    private PartService partService;


    @ApiOperation(value = "检查在新建章节中的章节序号是否合法")
    @GetMapping("/validIndex/{c_id}/{p_index}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "c_id",value = "课程编号",example =
            "aaa003",required = true),
            @ApiImplicitParam(name = "p_index" ,value = "章节编号",example = "3",required = true)
    })
    public String isValid(@PathVariable("c_id") String c_id,
            @PathVariable("p_index") Integer p_index){
        if(partService.hasCoursePartIndex(c_id,p_index)){
            //如果该课程有这个编号的章节了，那么就返回false
            return "failed";
        }
        else{
            return "success";
        }
    }






}
