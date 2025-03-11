package org.example.boot21_memberemail.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/member")
@Service
@RestController
public class MemberRestController {
    @Autowired
    MemberService memberService;
    @GetMapping("/emailSelectOne")
    public Map<String,Object> emailSelectOne(@RequestParam String email){
        log.info("emailSelectOne()");
        MemberVO vo = new MemberVO();
        vo = memberService.emailSelectOne(email);
        log.info("password :"+vo.getPw());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", vo.getPw());
        return map;

    }
}
