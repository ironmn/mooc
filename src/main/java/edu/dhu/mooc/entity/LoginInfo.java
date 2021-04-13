package edu.dhu.mooc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 17:35
 * @describe 用于给前端返回登录的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("返回给前端登录的信息")
public class LoginInfo {
    @ApiModelProperty(value = "登录验证信息",notes = "如果是success,表示成功" +
            "failed表示失败")
    private String info;

    @ApiModelProperty(example = "2084172")
    private String id;

    @ApiModelProperty(example = "student")
    private String role;

}
