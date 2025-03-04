package org.example.component_bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConfigurationProperties("car")
@Data
public class CarComponent {

    private String model;
    private int price;

    public CarComponent() {
        log.info("CarComponent ...");
    }

    public void start(){
        log.info("start()....");
    }

}
