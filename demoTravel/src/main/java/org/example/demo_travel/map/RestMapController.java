package org.example.demo_travel.map;

import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Slf4j
@Controller
@RequestMapping("/map")
public class RestMapController {
    @GetMapping("/kakaoMap_do")
    public String kakaoMap_do() {
        log.info("kakaoMap_do()...");
        return "map/kakao_map";
    }

}
