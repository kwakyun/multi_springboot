package org.example.boot13_mybatis.board;

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
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/insert")
    public String insert() {
        log.info("/board/insert");
        return "board/insert";
    }

    @GetMapping("/update")
    public String update(BoardVO vo, Model model) {
        log.info("/board/update");
        log.info("vo : {}",vo);

        BoardVO vo2 = service.selectOne(vo);
        log.info("vo2 : {}",vo2);

        model.addAttribute("vo2", vo2);

        return "board/update";
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("/board/delete");

        return "board/delete";
    }

    @GetMapping("/selectOne")
    public String selectOne(BoardVO vo, Model model) {
        log.info("/board/selectOne");
        log.info("vo : {}",vo);

        BoardVO vo2 = service.selectOne(vo);
        log.info("vo2 : {}",vo2);

        model.addAttribute("vo2", vo2);

        return "board/selectOne";
    }

    @GetMapping("/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit, Model model) {
        log.info("/board/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<BoardVO> vos = service.selectAll(cpage,limit);
        log.info("vos.size() : {}",vos.size());

        model.addAttribute("vos", vos);


        return "board/selectAll";
    }

    @GetMapping("/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "5")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model) {
        log.info("/board/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        List<BoardVO> vos = service.searchList(cpage,limit,searchKey,searchWord);
        log.info("vos.size() : {}",vos.size());

        model.addAttribute("vos", vos);

        return "board/selectAll";
    }

    @PostMapping("/insertOK")
    public String insertOK(BoardVO vo) {
        log.info("/board/insertOK");
        log.info("vo : {}",vo);

        int result = service.insertOK(vo);
        log.info("result : {}",result);

        if(result > 0) {
            return "redirect:/board/selectAll";
        }else{
            return "redirect:/board/insert";
        }
    }

    @PostMapping("/updateOK")
    public String updateOK(BoardVO vo) {
        log.info("/board/updateOK");
        log.info("vo : {}",vo);

        int result = service.updateOK(vo);
        log.info("result : {}",result);

        if(result > 0) {
            return "redirect:/board/selectOne?num="+vo.getNum();
        }else{
            return "redirect:/board/update?num="+vo.getNum();
        }

    }

    @GetMapping("/deleteOK")
    public String deleteOK(BoardVO vo) {
        log.info("/board/deleteOK");
        log.info("vo : {}",vo);

        int result = service.deleteOK(vo);
        log.info("result : {}",result);

        if(result > 0) {
            return "redirect:/board/selectAll";
        }else{
            return "redirect:/board/delete?num="+vo.getNum();
        }
    }


}//end class
