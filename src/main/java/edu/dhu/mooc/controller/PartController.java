package edu.dhu.mooc.controller;

import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.service.PartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

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


    @ApiOperation("为指定的课程插入新的章节")
    @PostMapping(value = "/insert")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "part",
            value = "章节对象",
            dataTypeClass = edu.dhu.mooc.entity.Part.class)
    )
    public String insertNewCoursePart(@RequestBody Part part)  {
        try{
            if(partService.addNewPart(part)){
                return "success";
            }
            else return "failed";
        }catch (Exception e){
            //从日志中捕获异常
            log.error(e.getMessage());
            return "failed";
        }
    }


    @ApiOperation("删除指定的章节")
    @PostMapping("/delete/{p_id}")

    public String deletePartById(@PathVariable("p_id") String p_id){
        try{
            if(partService.deletePart(p_id)){
                return "success";
            }
            else{
                return "failed";
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return "failed";
        }
    }
}
