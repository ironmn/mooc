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
 * @date 2021/4/7 11:13
 * @describe 章节的实体类
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Part {
    @ApiModelProperty(value = "章节对应的唯一id",example = "aaa004")
    private String p_id;
    @ApiModelProperty(value = "章节对应的编号",example = "1")
    private Integer p_index;
    @ApiModelProperty(value = "章节名字",example = "绪论")
    private String p_name;
}
