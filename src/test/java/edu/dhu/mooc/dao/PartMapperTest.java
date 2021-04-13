package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.entity.teacher.TeacherPart;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:53
 * @describe
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PartMapperTest {

    @Autowired
    private PartMapper partMapper;

    @Test
    void selectByPrimaryKey() {
        Part ans = partMapper.selectByPrimaryKey("aaa004_1");
        System.out.println(ans);
    }

    @Test
    public void getAllPartsByCourseId(){

         System
    .out.println(partMapper.getPartListByCourseId("aaa003"));

    }


    @Test
    public void insertTest(){
        Part part = new Part();
        part.setP_id("aaa004_1000");
        part.setP_index(1000);
        part.setP_name("这是测试章节的name");
        part.setC_id("aaa004");
        partMapper.insert(part);
    }
}