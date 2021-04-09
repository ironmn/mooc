package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.dao.TeacherMapper;
import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.Teacher;
import edu.dhu.mooc.entity.User;
import edu.dhu.mooc.service.LoginService;
import edu.dhu.mooc.utils.RandomFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     *@para user
     *@return ans
     */
    @Override
    public boolean hasAccount(User user) {
        String phone_num = user.getPhone();
        String pwd = user.getPassword();
        //获取学生和老师的对象
        List<Student> StudentList = studentMapper.selectByAccount(phone_num,pwd);

        List<Teacher> TeacherList = teacherMapper.selectByAccount(phone_num,pwd);

        if(StudentList.size()>0 || TeacherList.size()>0){
            //发现是学生的身份
            if(StudentList.size()>0){
                user.setRole("student");
            }
            //学生和老师的信息在数据库中保证不冲突
            else if(TeacherList.size()>0){
                user.setRole("teacher");
            }
            return true;
        }
        else return false;
    }

    /**
     *
     * @param user 前端传递的User对象
     * @return 实际在mysql中的表数据
     * @describe 通过User对象查询用户的实际id
     */
    @Override
    public String findIdByUser(User user) {
        String phone_num = user.getPhone();
        String pwd = user.getPassword();

        String role = user.getRole();
        if(role.equals("student")){
            List<Student> students = studentMapper.selectByAccount(phone_num, pwd);
            return students.get(0).getS_id();
        }
        else {
            List<Teacher> teachers = teacherMapper.selectByAccount(phone_num,pwd);
            return teachers.get(0).getT_id();
        }
    }

    @Override
    public boolean checkIfPhoneValid(String register_phone) {
        List<Student> students = studentMapper.selectAll();
        List<Teacher> teachers = teacherMapper.selectAll();
        List<String> phoneList = new ArrayList<>();
        for(Student s:students){
            phoneList.add(s.getPhone());
        }
        for (Teacher t : teachers){
            phoneList.add(t.getPhone());
        }
        for(String phone : phoneList){
            //如果发现有相同的电话号码，就返回false
            if(phone.equals(register_phone)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void insertUser(User user) {
        String role = user.getRole();
        String num = RandomFunctions.getRandomStuNum();
        if(role.equals("student")){
            Student stu = new Student();
            while (studentMapper.selectByPrimaryKey(num) != null){
                num = RandomFunctions.getRandomStuNum();
            }
            stu.setS_id(num);stu.setS_name(user.getName());
            stu.setPhone(user.getPhone());stu.setPassword(user.getPassword());
            stu.setGender(user.getGender());
            studentMapper.insert(stu);
        }
        else {
            Teacher teacher = new Teacher();
            while (teacherMapper.selectByPrimaryKey(num) != null){
                num = RandomFunctions.getRandomStuNum();
            }
            teacher.setT_id(num);
            teacher.setT_name(user.getName());
            teacher.setPassword(user.getPassword());
            teacher.setGender(user.getGender());
            teacher.setPhone(user.getPhone());
            teacherMapper.insert(teacher);
        }
    }
}
