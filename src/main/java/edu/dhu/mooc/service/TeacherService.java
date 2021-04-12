package edu.dhu.mooc.service;

import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.course.Course;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.teacher.TeacherCourse;
import edu.dhu.mooc.entity.teacher.TeacherPart;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/10 19:03
 * @describe 教师后台业务逻辑处理类
 */
public interface TeacherService {
    List<TeacherCourse> getMyTeachById(String t_id);

    //通过课程id获取学生的信息列表
    List<Student> getStudentListByCourseId(String c_id);

    List<TeacherPart> getMyPartListByCourseId(String c_id);
}
