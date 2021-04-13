package edu.dhu.mooc.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/10 19:58
 * @describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherCourse {
    private String c_id;
    private String c_name;
    private Integer c_count;
}
