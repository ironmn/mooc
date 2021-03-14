package edu.dhu.mooc.utils;

import edu.dhu.mooc.MoocApplication;
import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.dao.TeacherMapper;
import edu.dhu.mooc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.UUID;

/**
 * @Author: xieyiming
 * @date: 2021-03-14
 * @Describe: 数据库记录生成工具。
 * @Main Function:
 *  1. 后台测试的时候随机生成测试用例（无参）
 *  2. 用户注册后为用户随机分配一个id（有参，随机为该用户分配id）
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MoocApplication.class)
public class MysqlRecordGenerator {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * @describe: 无参随机生成一个学生信息
     */
    public void generateStudent(){
        Student student = new Student();
        String rand_id;
        while (studentMapper.selectByPrimaryKey(rand_id = UUID.randomUUID().toString())!=null){
        }
        student.setS_id(rand_id);
        student.setS_name(RandomFunctions.getRandomChineseName());
        student.setGender(RandomFunctions.getRandomGender());
        student.setPhone(RandomFunctions.getRandPhoneNumber());
        student.setPassword(RandomFunctions.getRandomPwd());
        student.setS_num(RandomFunctions.getRandomStuNum());
        studentMapper.insert(student);
    }
    @Test
    public void generateBatchRandomStudents(){
        for(int i = 0;i<100;i++){
            this.generateStudent();
        }
    }
}


