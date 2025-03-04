package org.example.boot04_thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class TestController {

    @GetMapping("/test/insert")
    public String insert() {
        log.info("/test/insert");
        return "test/insert";
    }

    @GetMapping("/test/update")
    public String update(TestVO vo) {
        log.info("/test/update");
        log.info("vo : {}", vo);
        return "test/update";
    }

    @GetMapping("/test/delete")
    public String delete() {
        log.info("/test/delete");
        return "test/delete";
    }

    @GetMapping("/test/selectOne")
    public String selectOne(TestVO vo) {
        log.info("/test/selectOne");
        log.info("vo : {}", vo);
        return "test/selectOne";
    }

    @GetMapping("/test/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1") int cpage,
            @RequestParam(defaultValue = "10") int limit) {
        log.info("/test/selectAll");
        log.info("cpage : {}", cpage);
        log.info("limit : {}", limit);
        return "test/selectAll";
    }

    @GetMapping("/test/searchList")
    public String searchList(int cpage,int limit,String searchKey,String searchWord) {
        log.info("/test/searchList");
        log.info("cpage : {}", cpage);
        log.info("limit : {}", limit);
        log.info("searchKey : {}", searchKey);
        log.info("searchWord : {}", searchWord);
        return "test/selectAll";
    }


    @GetMapping("/test/insertOK")
    public String insertOK(TestVO vo) {
        log.info("/test/insertOK");
        log.info("vo : {}", vo);
        return "redirect:/test/selectAll";
    }

    @GetMapping("/test/updateOK")
    public String updateOK(TestVO vo) {
        log.info("/test/updateOK");
        log.info("vo : {}", vo);
        return "redirect:/test/selectOne?num=" + vo.getNum();
    }

    @GetMapping("/test/deleteOK")
    public String deleteOK(TestVO vo) {
        log.info("/test/deleteOK");
        log.info("vo : {}", vo);
        return "redirect:/test/selectAll";
    }

    //boot05_thymeleaf_member 프로젝트생성하기.
    //HomeController,MemberController
    //타입리프를 이용한 뷰처리페이지 생성하기
    //학습한 내용처럼 화면 출력 및 로고출력 구현하기.

}
