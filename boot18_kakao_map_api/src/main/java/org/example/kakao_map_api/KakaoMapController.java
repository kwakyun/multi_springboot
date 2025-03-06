package org.example.kakao_map_api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/map")
public class KakaoMapController {

    @Autowired
    private KakaoMapService kakaoMapService;

    @GetMapping("/search")
    public String searchAddress(@RequestParam String address) {
        log.info("Search address: " + address);
        return kakaoMapService.searchAddress(address);
    }


}//end class
