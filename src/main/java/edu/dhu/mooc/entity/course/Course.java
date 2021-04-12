package edu.dhu.mooc.entity.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/19 18:04
 * @describe 课程实体类
 * @todo  每一个课程都需要邮箱，但是现在的这个课程实体类还没有绑定邮箱。
 */
@Data
@ApiModel
@ToString
@AllArgsConstructor
public class Course {
    @ApiModelProperty(value ="课程编号",dataType = "java.lang.String",required = true,example = "aaa001")
    private String c_id;
    @ApiModelProperty(value = "课程对应的教师编号",dataType = "java.lang.String",
            required = true,example = "10101011")
    private String t_id;
    @ApiModelProperty(value = "课程名",dataType = "string",required = true,example = "中国近代史")
    private String c_name;
    @ApiModelProperty(value = "课程内容",dataType = "string",example = "本节课是大一学生的必修课" +
            "，主要内容如下：xxxxxxx")
    private String c_content;

    @ApiModelProperty(value = "课程被选的人数",
            dataType = "java.lang.Integer" ,
            example = "13" )
    private Integer c_count;
}
