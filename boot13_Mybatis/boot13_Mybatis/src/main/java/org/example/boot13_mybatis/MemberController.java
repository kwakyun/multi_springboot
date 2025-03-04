package org.example.boot13_mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/insert")
    public String insert() {
        log.info("/member/insert");
        return "member/insert";
    }

    @GetMapping("/update")
    public String update(MemberVO vo, Model model) {
        log.info("/member/update");
        log.info("vo : {}",vo);

        MemberVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "member/update";
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("/member/delete");

        return "member/delete";
    }

    @GetMapping("/selectOne")
    public String selectOne(MemberVO vo, Model model) {
        log.info("/member/selectOne");
        log.info("vo : {}",vo);

        MemberVO vo2 = service.selectOne(vo);
        model.addAttribute("vo2", vo2);

        return "member/selectOne";
    }

    @GetMapping("/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit, Model model) {
        log.info("/member/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<MemberVO> vos = service.selectAll(cpage, limit);
        model.addAttribute("vos", vos);


        return "member/selectAll";
    }

    @GetMapping("/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model ) {
        log.info("/member/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        List<MemberVO> vos = service.searchList(cpage, limit, searchKey, searchWord);
        model.addAttribute("vos", vos);

        return "member/selectAll";
    }

    @PostMapping("/insertOK")
    public String insertOK(MemberVO vo) {
        log.info("/member/insertOK");
        log.info("vo : {}",vo);

        int result = service.insertOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectAll";
        }else{
            return "redirect:/member/insert";
        }
    }

    @PostMapping("/updateOK")
    public String updateOK(MemberVO vo) {
        log.info("/member/updateOK");
        log.info("vo : {}",vo);

        int result = service.updateOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectOne?num="+vo.getNum();
        }else{
            return "redirect:/member/update?num="+vo.getNum();
        }
    }

    @GetMapping("/deleteOK")
    public String deleteOK(MemberVO vo) {
        log.info("/member/deleteOK");
        log.info("vo : {}",vo);

        int result = service.deleteOK(vo);
        log.info("result : {}",result);

        if(result  > 0) {
            return "redirect:/member/selectAll";
        }else{
            return "redirect:/member/delete?num="+vo.getNum();
        }
    }


}//end class
