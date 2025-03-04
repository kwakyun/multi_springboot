package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBean {

    public TestBean() {
        log.info("TestBean...");
    }

    public void stop(){
        log.info("stop()...");
    }
}
