package edu.dhu.mooc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoocApplication.class, args);
    }

}
