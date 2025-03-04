package org.example.boot05_thymeleaf_member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/member/insert")
    public String insert() {
        log.info("/member/insert");
        return "member/insert";
    }

    @GetMapping("/member/update")
    public String update(MemberVO vo) {
        log.info("/member/update");
        log.info("vo : {}",vo);
        return "member/update";
    }

    @GetMapping("/member/delete")
    public String delete() {
        log.info("/member/delete");

        return "member/delete";
    }

    @GetMapping("/member/selectOne")
    public String selectOne(MemberVO vo) {
        log.info("/member/selectOne");
        log.info("vo : {}",vo);
        return "member/selectOne";
    }

    @GetMapping("/member/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit) {
        log.info("/member/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        return "member/selectAll";
    }

    @GetMapping("/member/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord
            ) {
        log.info("/member/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        return "member/selectAll";
    }

    @PostMapping("/member/insertOK")
    public String insertOK(MemberVO vo) {
        log.info("/member/insertOK");
        log.info("vo : {}",vo);
        return "redirect:/member/selectAll";
    }

    @PostMapping("/member/updateOK")
    public String updateOK(MemberVO vo) {
        log.info("/member/updateOK");
        log.info("vo : {}",vo);
        return "redirect:/member/selectOne?num="+vo.getNum();
    }

    @GetMapping("/member/deleteOK")
    public String deleteOK(MemberVO vo) {
        log.info("/member/deleteOK");
        log.info("vo : {}",vo);
        return "redirect:/member/selectAll";
    }


}
