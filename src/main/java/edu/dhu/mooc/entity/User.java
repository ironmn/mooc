package edu.dhu.mooc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User implements Serializable {
    @ApiModelProperty(value = "电话号码",example = "13410779145")
    private String phone;
    @ApiModelProperty(value = "密码",example = "123456")
    private String password;
    @ApiModelProperty(value = "用户身份",notes = "用于标注用户是老师还是学生",example = "student",allowEmptyValue = false)
    private String role;
    @ApiModelProperty(value = "性别",notes = "用户标注男女",example = "male")
    private String gender;
    @ApiModelProperty(value = "姓名",notes = "用户的真实姓名",example = "张三")
    private String name;
}
