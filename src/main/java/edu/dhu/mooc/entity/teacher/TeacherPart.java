package edu.dhu.mooc.entity.teacher;

import edu.dhu.mooc.entity.Part;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 19:35
 * @describe 对于Part这个类的扩充
 */

@ApiModel
@NoArgsConstructor
public class TeacherPart extends Part {


    @ApiModelProperty(value = "用于表示该章节是否已经上传了课件",name = "has_file"
    ,notes = "只对应两种状态：’未上传‘和’已上传‘，其余情况不存在",
    example = "未上传")
    private String file_status;

    @ApiModelProperty(value = "同上，但表示家庭作业",notes = "只有两种状态：未发布和已发布",
    example = "未发布")
    private String homework_status;


    //全参构造函数(调用父类的全参构造函数)
    public TeacherPart(String p_id,Integer p_index,
                       String p_name,String has_file,String has_homework){
        super(p_id,p_index,p_name);
        this.file_status = has_file;this.homework_status = has_homework;
    }

    public TeacherPart(Part part){
        super(part.getP_id(),part.getP_index(),part.getP_name());
        this.file_status = "未上传";this.homework_status = "未发布";
    }

    public String getFile_status() {
        return file_status;
    }

    public void setFile_status(String has_file) {
        this.file_status = has_file;
    }

    public String getHomework_status() {
        return homework_status;
    }

    public void setHomework_status(String homework_status) {
        this.homework_status = homework_status;
    }

    @Override
    public String toString() {
        return
                "TeacherPart{" + super.toString() +
                "has_file='" + file_status + '\'' +
                ", homework_status='" + homework_status + '\'' +
                '}';
    }
}
