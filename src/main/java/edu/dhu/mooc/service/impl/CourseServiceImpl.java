package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.dao.CourseMapper;
import edu.dhu.mooc.entity.course.CourseDetail;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 21:33
 * @describe 具体实现
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseInfo> findCourseListById(String s_id) {
        return courseMapper.findCourseListById(s_id);
    }

    @Override
    public List<Part> findPartListById(String c_id) {
        List<Part> parts = courseMapper.selectPartList(c_id);
        return parts;
    }

    //查询所有的选课列表
    @Override
    public List<CourseInfo> findAllCourseList() {
        return courseMapper.findAllCourseInfoList();
    }

    @Override
    public CourseDetail getCourseDetailById(String c_id) {
        return courseMapper.findCourseDetailById(c_id);
    }
}
