package org.example.boot20_sendemail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/","/home"})
    public String home() {
        return "home";
    }
}//end class
