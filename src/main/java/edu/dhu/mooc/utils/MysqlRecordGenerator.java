package edu.dhu.mooc.utils;

import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.dao.TeacherMapper;
import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Random;
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
@Component
public class MysqlRecordGenerator {

    @Autowired
    private static StudentMapper studentMapper;

    @Autowired
    private static TeacherMapper teacherMapper;

    /**
     * @describe: 无参随机生成一个学生信息
     */
    public static void generateStudent(){
        Student student = new Student();
        String rand_id;
        while (studentMapper.selectByPrimaryKey(rand_id = UUID.randomUUID().toString())!=null){
        }
        student.setS_id(rand_id);
        student.setS_name(RandomFunctions.getRandomChineseName());
        student.setGender(RandomFunctions.getRandomGender());
        student.setPhone(RandomFunctions.getRandPhoneNumber());
        student.setS_num(RandomFunctions.getRandomStuNum());
        System.out.println(student);
    }

}


