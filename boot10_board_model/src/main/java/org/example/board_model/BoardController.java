package org.example.board_model;

import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/insert")
    public String insert() {
        log.info("/board/insert");
        return "board/insert";
    }

    @GetMapping("/update")
    public String update(BoardVO vo, Model model) {
        log.info("/board/update");
        log.info("vo : {}",vo);

        BoardVO vo2 = new BoardVO();
        vo2.setNum(4);
        vo2.setTitle("title4");
        vo2.setContent("content4");
        vo2.setWriter("writer4");
        vo2.setWdate("2025-12-25");
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

        BoardVO vo2 = new BoardVO();
        vo2.setNum(4);
        vo2.setTitle("title4");
        vo2.setContent("content4");
        vo2.setWriter("writer4");
        vo2.setWdate("2025-12-25");
        model.addAttribute("vo2", vo2);

        return "board/selectOne";
    }

    @GetMapping("/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit, Model model) {
        log.info("/board/selectAll");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);

        List<BoardVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BoardVO vo = new BoardVO();
            vo.setNum((i+1));
            vo.setTitle("title"+(i+1));
            vo.setContent("content"+(i+1));
            vo.setWriter("writer"+(i+1));
            vo.setWdate("2025-12-2"+(i+1));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);


        return "board/selectAll";
    }

    @GetMapping("/searchList")
    public String searchList(
            @RequestParam(defaultValue = "1")int cpage,
            @RequestParam(defaultValue = "10")int limit,
            @RequestParam(defaultValue = "name")String searchKey,
            @RequestParam(defaultValue = "")String searchWord,
            Model model) {
        log.info("/board/searchList");
        log.info("cpage: {}",cpage);
        log.info("limit: {}",limit);
        log.info("searchKey: {}",searchKey);
        log.info("searchWord: {}",searchWord);

        List<BoardVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BoardVO vo = new BoardVO();
            vo.setNum((i+1));
            vo.setTitle("title"+(i+1));
            vo.setContent("content"+(i+1));
            vo.setWriter("writer"+(i+1));
            vo.setWdate("2025-12-2"+(i+1));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);

        return "board/selectAll";
    }

    @PostMapping("/insertOK")
    public String insertOK(BoardVO vo) {
        log.info("/board/insertOK");
        log.info("vo : {}",vo);
        return "redirect:/board/selectAll";
    }

    @PostMapping("/updateOK")
    public String updateOK(BoardVO vo) {
        log.info("/board/updateOK");
        log.info("vo : {}",vo);
        return "redirect:/board/selectOne?num="+vo.getNum();
    }

    @GetMapping("/deleteOK")
    public String deleteOK(BoardVO vo) {
        log.info("/board/deleteOK");
        log.info("vo : {}",vo);
        return "redirect:/board/selectAll";
    }


}
