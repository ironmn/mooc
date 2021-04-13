package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.entity.teacher.TeacherCourse;
import edu.dhu.mooc.entity.teacher.TeacherPart;
import edu.dhu.mooc.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/10 20:03
 * @describe
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class TeacherServiceImplTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    void getMyTeachById() {
        List<TeacherCourse> myTeachById = teacherService.getMyTeachById("10101013");
        System.out.println(myTeachById);
    }

    @Test
    public void getMyPartListByCourseIdTest(){
        List<TeacherPart> ans = teacherService.getMyPartListByCourseId("aaa003");
        for(TeacherPart pt : ans){
            System.out.println(pt);
        }
    }
}