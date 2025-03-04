package org.example.fundamental;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
    public String selectOne(TestVO vo, Model model) {
        log.info("/test/selectOne");
        log.info("vo : {}", vo);

        //service >> dao >> daoimpl >> return vo2
        TestVO vo2 = new TestVO();
        vo2.setNum(1);
        vo2.setName("kim");
        vo2.setAge(33);
        model.addAttribute("vo2", vo2);

        return "test/selectOne";
    }

    @GetMapping("/test/selectAll")
    public String selectAll(
            @RequestParam(defaultValue = "1") int cpage,
            @RequestParam(defaultValue = "10") int limit,
            Model model) {
        log.info("/test/selectAll");
        log.info("cpage : {}", cpage);
        log.info("limit : {}", limit);

        //service >> dao >> daoimpl >> return vos
        List<TestVO> vos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TestVO vo = new TestVO();
            vo.setNum(1+i);
            vo.setName("kim"+(1+i));
            vo.setAge(30+(1+i));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);

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

}
