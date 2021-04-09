package edu.dhu.mooc.service.impl;

import edu.dhu.mooc.entity.User;
import edu.dhu.mooc.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/27 17:49
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class LoginServiceImplTest {

    @Autowired
    private LoginService loginService;

//    @Test
//    public void findIdByUserTest(){
//        User user = new User("13410779145","123456","student");
//        String idByUser = loginService.findIdByUser(user);
//        System.out.println(idByUser);
//
//    }

    /**
     * 经过测试，该方法能够正确运行
     */
    @Test
    public void checkIfPhoneValid(){
//        boolean b = loginService.checkIfPhoneValid("15333061275");
//        System.out.println(b);

        boolean b = loginService.checkIfPhoneValid("15333061276");
        System.out.println(b);
    }

}