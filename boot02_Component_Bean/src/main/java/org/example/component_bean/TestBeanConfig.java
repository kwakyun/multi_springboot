package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TestBeanConfig {

    public TestBeanConfig() {
        log.info("TestBeanConfig...");
    }

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("kim");
        p.setAge(33);
        return p;
    }

    //Student 빈으로 등록하기.
    @Bean
    public Student student() {
        return new Student(person());
    }


}
