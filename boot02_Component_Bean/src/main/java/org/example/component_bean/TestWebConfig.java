package org.example.component_bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestWebConfig implements WebMvcConfigurer {

    //메소드 오버라이드를 통해서 웰컴파일을 변경해 줄 수 있다.
    //ex : http://localhost:8802 >>> index.html >> hello.html 변경가능.
    //resources/static/hello.html 생성해준다.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/hello.html");
    }
}
