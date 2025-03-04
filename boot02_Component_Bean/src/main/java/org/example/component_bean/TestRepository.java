package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TestRepository {

    public TestRepository(){
        log.info("TestRepository ...");
    }

    public void start(){
        log.info("start() ...");
    }
}
