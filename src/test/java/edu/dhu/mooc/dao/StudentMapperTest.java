package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.Student;
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
 * @date 2021/4/12 13:41
 * @describe
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class StudentMapperTest {


    @Autowired
    private StudentMapper studentMapper;

    @Test
    void getStudentListByCourseId() {
        List<Student> list = studentMapper.getStudentListByCourseId("aaa001");
        for(Student s : list){
            System.out.println(s);
        }
    }
}