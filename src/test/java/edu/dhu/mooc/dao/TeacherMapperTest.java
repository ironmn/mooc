package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.teacher.TeacherCourse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/10 19:42
 * @describe
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void findMyTeachCourseTest() {
        List<TeacherCourse> ans = teacherMapper.findMyTeachCourse("10101013");

        for(TeacherCourse c : ans){
            System.out.println(c);
        }
    }

    /**
     * 通过课程id查询学生信息，测试
     */
    @Test
    public void findStudentListByCourseId(){
        List<Student> ans
                = teacherMapper.getStudentListByCourseId("aaa001");
        for(Student s : ans ){
            System.out.println(s);
        }
    }
}