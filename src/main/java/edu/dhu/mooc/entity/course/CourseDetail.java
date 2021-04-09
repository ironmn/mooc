package edu.dhu.mooc.entity.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/9 14:49
 * @describe 用于在选课页面显示课程的内容
 */
@ApiModel(value = "用于返回给前端页面的课程详情数据结构")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDetail implements Serializable {
    @ApiModelProperty(value = "课程编号",example = "aaa001")
    private String c_id;

    @ApiModelProperty(value = "课程名称",example = "中国近代史")
    private String c_name;

    @ApiModelProperty(value = "任课教师的名字",example = "张恒")
    private String t_name;

    @ApiModelProperty(value = "课程简介",example = "这是一门为大一学生开设的课程")
    private String c_content;
}
