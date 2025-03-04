package org.example.member_model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/member/insert")
    public String insert() {
        log.info("/member/insert");
        return "member/insert";
    }

    @GetMapping("/member/update")
    public String update(MemberVO vo, Model model) {
        log.info("/member/update");
        log.info("vo : {}",vo);

        MemberVO vo2 = new MemberVO();
        vo2.setNum(4);
        vo2.setId("admin44");
        vo2.setPw("hi444");
        vo2.setName("kim4");
        vo2.setTel("044");
        model.addAttribute("vo2", vo2);

        return "member/update";
    }

    @GetMapping("/member/delete")
    public String delete() {
        log.info("/member/delete");

        return "member/delete";
    }

    @GetMapping("/member/selectOne")
    public String selectOne(MemberVO vo, Model model) {
        log.info("/member/selectOne");
        log.info("vo : {}",vo);

        MemberVO vo2 = new MemberVO();
        vo2.setNum(1);
        vo2.setId("admin");
        vo2.setPw("hi1111");
        vo2.setName("kim");
        vo2.setTel("011");
        model.addAttribute("vo2", vo2);

        return "member/selectOne";
    }

    @GetMapping("/member/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit, Model model) {
        log.info("/member/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<MemberVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MemberVO vo = new MemberVO();
            vo.setNum(i+1);
            vo.setId("admin"+(i+1));
            vo.setPw("hi1111"+(i+1));
            vo.setName("kim"+(i+1));
            vo.setTel("011"+(i+1));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);


        return "member/selectAll";
    }

    @GetMapping("/member/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model ) {
        log.info("/member/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        List<MemberVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MemberVO vo = new MemberVO();
            vo.setNum(i+1);
            vo.setId("admin"+(i+1));
            vo.setPw("hi1111"+(i+1));
            vo.setName("kim"+(i+1));
            vo.setTel("011"+(i+1));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);

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
