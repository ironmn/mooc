package edu.dhu.mooc;

import edu.dhu.mooc.dao.StudentMapper;
import edu.dhu.mooc.utils.MysqlRecordGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MoocApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
        System.out.println(studentMapper);
    }
}
