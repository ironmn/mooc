package edu.dhu.mooc.controller;

import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.course.Course;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.teacher.TeacherCourse;
import edu.dhu.mooc.entity.teacher.TeacherPart;
import edu.dhu.mooc.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/19 17:59
 * @describe 老师教学管理页面
 * @todo TeacherPart还没有完成文件和作业的校验功能
 */
@Api(value = "教师后台课程管理")
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "查询上的课")

    @GetMapping("/myTeach/{t_id}")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "t_id",value = "教师id",required = true,example = "10101013")
    )
    public List<TeacherCourse> getMyTeachList(@PathVariable("t_id") String t_id){
        return teacherService.getMyTeachById(t_id);
    }

    @ApiOperation(value = "提交取消这门课的请求",
                notes = "老师将请求交给后台的管理员进行处理。只有管理员有权限对老师的" +
                        "课程进行操作")
    @PostMapping("/delete/{c_id}/{t_id}")
    public String delCourse(@PathVariable("c_id") String c_id,
                            @PathVariable("t_id") String t_id){
        return null;
    }

    @ApiOperation(value = "通过课程id获取学生列表",
        notes = "通过接受前端传递的c_id参数，来获取学生名单")
    @GetMapping("/getStuMenu/{c_id}")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "c_id",value = "课程id",
                    example = "aaa001",required = true,type = "string"
            )
    )
    public List<Student> getStudentMenu(@PathVariable("c_id") String c_id){
        return teacherService.getStudentListByCourseId(c_id);
    }


    @ApiOperation(value = "获取教师端的章节列表",notes = "这里的章节信息主要包括作业的发布情况，文件的上传等等")
    @GetMapping("/getTeacherPart/{c_id}")

    public List<TeacherPart> getTeacherPart(@PathVariable("c_id") String c_id){
        return teacherService.getMyPartListByCourseId(c_id);
    }

    @ApiOperation(value = "用于判断课程名是否重复",notes = "前端创建页面的时候需要用到.传入的参数分别是老师的ID和对应的" +
            "课程名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "t_id",example = "19281341485"),
            @ApiImplicitParam(name = "c_name",example = "test")
    })
    @PostMapping("/validCourse")

    public String checkIfCNameValid(@RequestParam("t_id") String t_id,
                                    @RequestParam("c_name") String c_name){
        if(teacherService.findDuplicatedCourseName(t_id,c_name)){
            //表示有这门课了，就返回failed信号
            return "failed";
        }
        //表示没有这门课，那么就返回成功的信号
        return "success";
    }
}
