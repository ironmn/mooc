package edu.dhu.mooc.entity.course;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xie yiming
 * @version 1.0
 *
 * @date 2021/3/27 20:02
 * @describe 选课列表对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("返回给前端的课程信息记录")
public class CourseInfo {

    @ApiModelProperty(value = "课程编号",example = "aaa001")
    private String c_id;

    @ApiModelProperty(value = "课程名称",example = "中国近代史")
    private String c_name;

    @ApiModelProperty(value = "任课教师的名字",example = "张恒")
    private String t_name;
}
