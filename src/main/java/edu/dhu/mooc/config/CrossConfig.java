package edu.dhu.mooc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/3/26 9:04
 * @describe 解决登录的跨域问题
 */
@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(false)
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedOrigins("*");
    }
}
