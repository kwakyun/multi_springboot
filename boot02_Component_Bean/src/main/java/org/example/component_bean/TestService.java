package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public TestService(){
        log.info("TestService ...");
    }

    public void start(){
        log.info("start() ...");
        testRepository.start();
    }
}
