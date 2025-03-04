package org.example.fundamental;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    HttpSession session;

    @GetMapping({"/","/home"})
    public String home(Model model) {
        log.info("/home");

        model.addAttribute("message", "Hello World");
        model.addAttribute("to_day", new Date());
        model.addAttribute("tag_h1", "<h1>kim</h1>");

        TestVO vo = new TestVO();
        vo.setNum(1);
        vo.setName("kim");
        vo.setAge(33);
        model.addAttribute("vo", vo);

        List<TestVO> vos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vo = new TestVO();
            vo.setNum(1+i);
            vo.setName("kim"+(1+i));
            vo.setAge(30+(1+i));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);

        session.setAttribute("nickname", "YANGSSEM");

        return "home";
    }

}
