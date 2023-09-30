package java.org.example.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.org.example.service.MyIntersepter;

@Configuration
@EnableWebMvc
public class ExtraWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new MyIntersepter());
    }
}
