package org.example.boot04_thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HomeController {

    //@ResponseBody //REST api구현을 위한 어노테이션
    @GetMapping({"/","/home"})
    public String home() {
        log.info("/home");
        return "home";
    }
}
