package edu.dhu.mooc.service;

import edu.dhu.mooc.entity.course.CourseDetail;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.Part;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 21:33
 * @describe 处理课程业务
 */

public interface CourseService {

    List<CourseInfo> findCourseListById(String s_id);

    List<Part> findPartListById(String c_id);

    List<CourseInfo> findAllCourseList();

    CourseDetail getCourseDetailById(String c_id);
}
