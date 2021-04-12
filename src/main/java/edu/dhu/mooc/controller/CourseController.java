package edu.dhu.mooc.controller;

import edu.dhu.mooc.entity.course.CourseDetail;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.service.CourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 21:26
 * @describe 对前端的课程相关请求做出回应
 */
@RestController
@RequestMapping("/course")
@Api(tags = "处理课程请求")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     *
     * @param s_id 学生的id
     * @return CourseInfo类对象的集合
     * @testResult OK
     */
    @ApiOperation(value = "查询某个学生选的所有课程",notes = "接受一个从前端传递的id,返回该id对应的所有课程信息")
    @GetMapping("/myCourse/{s_id}")
    public List<CourseInfo> getSelectedCourseList(@PathVariable("s_id") String s_id){
        return courseService.findCourseListById(s_id);
    }


    /**
     * 经过swagger在线接口测试，该后端的方法能够成功响应
     * @return
     */
    @ApiOperation(value = "查询所有的课程列表",notes = "将course表中的所有课程信息都以CourseInfo类的形式" +
            "返回给前端",httpMethod = "GET"
                )
    @GetMapping("/list")
    public List<CourseInfo> getAllCourseList(){
        return courseService.findAllCourseList();
    }

    @ApiOperation(value = "查询课程的章节列表",
            notes = "从前端接受课程的c_id,返回该id对应的课程所有章节列表")
    @GetMapping("/getPartList/{c_id}")
    public List<Part> getPartListByCourseId(@PathVariable("c_id") String c_id){
        return courseService.findPartListById(c_id);
    }

    @ApiOperation(value = "查看课程详情",notes = "和上述的接口不同，该接口的功能是将课程的简介也返回给" +
            "前端页面")
    @GetMapping("/getDetail/{c_id}")
    public CourseDetail getCourseDetailById(@PathVariable("c_id") String c_id){
        return courseService.getCourseDetailById(c_id);
    }

    @ApiOperation(value = "选课",notes = "通过id选择要选的课程")
    @PostMapping("/add/{c_id}/{s_id}")
    //同时把学生的学号和课程的编号加进去
    public String addCourse(@PathVariable("c_id") String c_id,
                            @PathVariable("s_id") String s_id){
        //如果插入成功，那么返回success信息
        if(courseService.addCourse(c_id,s_id)){
            return "success";
        }
        //如果插入失败，也就是该课程已经存在了，那么返回错误的消息
        else{
            return "failed";
        }
    }

    @ApiOperation(value = "退课",notes = "通过学生id和课程id删除选课记录")
    @PostMapping("/delete/{c_id}/{s_id}")
    public String dropSCRecordById(@PathVariable("c_id") String c_id,
                                   @PathVariable("s_id") String s_id){
        try{
            courseService.dropSCRecordById(c_id,s_id);
        }catch (Exception e){
            //如果出现异常就返回错误的信息
            e.printStackTrace();
            return  "failed";
        }
        return "success";
    }
}
