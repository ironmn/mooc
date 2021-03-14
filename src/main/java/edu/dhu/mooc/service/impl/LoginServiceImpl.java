package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.dao.TeacherMapper;
import edu.dhu.mooc.entity.Student;
import edu.dhu.mooc.entity.Teacher;
import edu.dhu.mooc.entity.User;
import edu.dhu.mooc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean hasAccount(User user) {
        String phone_num = user.getPhone();
        String pwd = user.getPassword();
        List<Student> StudentList = studentMapper.selectByAccount(phone_num,pwd);

        List<Teacher> TeacherList = teacherMapper.selectByAccount(phone_num,pwd);

        if(StudentList.size()>0 || TeacherList.size()>0){
            return true;
        }
        else return false;
    }
}
