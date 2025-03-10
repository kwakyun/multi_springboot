package org.example.component_bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties("user")
@Data
public class UserComponent {

    private String user_name;
    private int user_age;

    public UserComponent() {
        log.info("UserComponent ...");
        //컴포넌트 등록 시점에서는 값설정 안됨.
        log.info("user_name : " + user_name);
        log.info("user_age : " + user_age);
    }

    public void start(){
        log.info("UserComponent start");
    }

}
