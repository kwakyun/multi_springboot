package org.example.component_bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {
    private String name;
    private int age;

    public void sleep(){
        log.info("sleep()...");
    }
}
