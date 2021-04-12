package edu.dhu.mooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/19 8:39
 * @describe
 */
@Configuration
@EnableSwagger2 //启用Swagger文档
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){//创建一个名为createRestApi 的文档
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.dhu.mooc.controller"))//选择基础的包路径
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("Mooc项目后台Swagger文档")
                        .description("后端API接口文档")
                        .version("9.0")
                        .contact(new Contact("xieyiming","","181100252@mail.dhu.edu.cn"))
                        .build());
    }
}
