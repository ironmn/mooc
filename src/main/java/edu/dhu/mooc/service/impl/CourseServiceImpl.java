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

    /**
     *
     * @param c_id
     * @param s_id
     * @return boolean
     * @apiNote false表示选课出现错误，true表示正常
     */
    @Override
    public boolean addCourse(String c_id, String s_id) {
        //先找出学生选的课程。
        //如果发现有重复，那么就不选
        List<CourseInfo> courseListById = courseMapper.findCourseListById(s_id);
        for(CourseInfo tmp : courseListById){
            //如果发现课程的编号出现重复，就返回false；
            if(tmp.getC_id().equals(c_id)){
                return false;
            }
        }
        //由于sc表有外键约束，如果记录的内容有问题，就会产生异常
        try{
            courseMapper.addSCRecord(s_id,c_id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 删除选课
     * @param c_id 课程id
     * @param s_id 学生id
     */
    @Override
    public void dropSCRecordById(String c_id, String s_id) throws Exception {
        courseMapper.dropSCRecordById(c_id,s_id);
    }
}
