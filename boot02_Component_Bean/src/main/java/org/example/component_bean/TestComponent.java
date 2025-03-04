package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestComponent implements ApplicationRunner {

    //의존성주입(DI)
    @Autowired
    UserComponent userComponent;

    @Autowired
    CarComponent carComponent;

    public TestComponent() {
        log.info("TestComponent ...");
        log.info("UserComponent:{}",userComponent);//DI이전
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("TestComponent ...run()...");
        log.info("UserComponent:{}",userComponent);//DI이후
        userComponent.start();
        log.info("CarComponent:{}",carComponent);
        carComponent.start();
    }
}
