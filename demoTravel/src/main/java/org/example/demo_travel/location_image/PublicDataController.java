package org.example.demo_travel.location_image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/location_image")
public class PublicDataController {

    @Autowired
    private PublicDataService service;

    @GetMapping("/image")
    public String image(String title, Model model) {
        log.info("/image");
        log.info(title);

        //String imageUrl = "http://tong.visitkorea.or.kr/cms2/website/66/3023466.jpg";
        String imageUrl = service.getImageUrl(title);
        model.addAttribute("imageUrl", imageUrl);

        return "/travel/selectOne";
    }
}
