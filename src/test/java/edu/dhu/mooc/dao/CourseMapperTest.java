package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.course.CourseDetail;
import edu.dhu.mooc.entity.course.CourseInfo;
import edu.dhu.mooc.entity.Part;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 21:44
 * @describe
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void findCourseListByIdTest(){
        List<CourseInfo> ans = courseMapper.findCourseListById("2154445");

        for(CourseInfo tmp : ans){
            System.out.println(tmp);
        }
    }

    @Test
    public void findPartList(){
        List<Part> aaa004 = courseMapper.selectPartList("aaa004");
        for(Part p : aaa004){
            System.out.println(p);
        }
    }

    @Test
    public void findAllCourseInfoTest(){
        List<CourseInfo> ans = courseMapper.findAllCourseInfoList();
        for(CourseInfo tmp : ans){
            System.out.println(tmp);
        }
    }


    /**
     * 查询成功，通过课程id来查询课程详情功能没有问题
     *
     */
    @Test
    public void FormattedCourseDetailTest(){
        CourseDetail ans = courseMapper.findCourseDetailById("aaa004");
        System.out.println(ans);
    }


    /**
     * 测试成功
     */
    @Test
    public void addSCRecordTest(){
        courseMapper.addSCRecord("1189360","aaa001");
    }
}
