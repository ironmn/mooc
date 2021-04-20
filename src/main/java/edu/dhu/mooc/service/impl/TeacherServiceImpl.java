package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.dao.CourseMapper;
import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.dao.TeacherMapper;
import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.course.Course;
import edu.dhu.mooc.entity.teacher.TeacherCourse;
import edu.dhu.mooc.entity.teacher.TeacherPart;
import edu.dhu.mooc.service.TeacherService;
import edu.dhu.mooc.utils.FileSystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/10 19:03
 * @describe 具体实现
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 通过教师的id返回该教师上的所有课
     * @param t_id
     * @return
     */
    @Override
    public List<TeacherCourse> getMyTeachById(String t_id) {
        return teacherMapper.findMyTeachCourse(t_id);
    }

    /**
     * 由于返回的Student对象，所以最后使用studentMapper这个代理类
     * 因为这个代理类已经实现了从sql结果到java对象的映射
     * @param c_id
     * @return
     */
    @Override
    public List<Student> getStudentListByCourseId(String c_id) {
        return studentMapper.getStudentListByCourseId(c_id);
    }


    @Override
    public List<TeacherPart> getMyPartListByCourseId(String c_id) {
        List<Part> originParts = courseMapper.selectPartList(c_id);
        int len = originParts.size();
        List<TeacherPart> ans = new ArrayList<>();
        for(int i = 0;i<len;i++){
            ans.add(i,new TeacherPart(originParts.get(i)));
            File test_file = new File(FileSystemUtil.PDF_CONTEXT_PATH
                    +originParts.get(i).getP_id()+".pdf");
            //如果课件存在，就设置为已上传
            if(test_file.exists()){
                ans.get(i).setFile_status("已上传");
            }
            else{
                ans.get(i).setFile_status("未上传");
            }
            ans.get(i).setHomework_status("未发布");
        }
        return ans;
    }

    @Override
    public boolean findDuplicatedCourseName(String t_id, String c_name) {
        List<Course> list = courseMapper.selectByT_idAndC_name(t_id, c_name);
        //如果说list大小为0或者为空
        if(list.size() < 1 || list == null){
            //表示没有这个课程，可以添加
            return false;
        }
        //表示有这个课程
        return true;
    }
}
