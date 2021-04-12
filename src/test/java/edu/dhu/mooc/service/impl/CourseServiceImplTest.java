package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/7 12:53
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void findPartListByIdTest(){
        List<Part> list = courseService.findPartListById("aaa004");
        for(Part p :list){
            System.out.println(p);
        }
    }

}