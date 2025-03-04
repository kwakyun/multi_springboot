package org.example.rest_swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api")
public class TestRestController {

    //@ResponseBody //@RestController에서는 생략되어있다.
    @GetMapping("/json_selectOne.do")
    public TestVO json_selectOne(TestVO vo) {
        log.info("api/json_selectOne.do...");
        log.info("vo: {}" , vo);

        //service >>  dao >> daoimpl >> return vo2 받았다라고 가정
        TestVO vo2 = new TestVO();
        vo2.setNum(vo.getNum());
        vo2.setName("yang");
        vo2.setNickname("yangssem");
        vo2.setAge(33);
        return vo2;
    }

    @GetMapping("/json_selectAll.do")
    public List<TestVO> json_selectAll() {
        log.info("api/json_selectAll.do...");

        //service >>  dao >> daoimpl >> return vos 받았다라고 가정
        List<TestVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestVO vo = new TestVO();
            vo.setNum(i+1);
            vo.setName("yang"+(i+1));
            vo.setNickname("yangssem"+(i+1));
            vo.setAge(33);
            vos.add(vo);
        }
        return vos;
    }

    @GetMapping("/json_searList.do")
    public List<TestVO> json_searList(String searchKey,String searchWord) {
        log.info("api/json_searList.do...");
        log.info("searchKey: " + searchKey);
        log.info("searchWord: " + searchWord);

        //service >>  dao >> daoimpl >> return vos 받았다라고 가정
        List<TestVO> vos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestVO vo = new TestVO();
            vo.setNum(i+1);
            vo.setName("yang"+(i+1));
            vo.setNickname("yangssem"+(i+1));
            vo.setAge(33);
            vos.add(vo);
        }
        return vos;
    }

    @PostMapping("/json_insertOK.do")
    public Map<String,Object> json_insertOK(@RequestBody TestVO vo) {
        //@RequestBody : 서블릿 post요청시 파라메터가 JSON객체로 넘어올때 TestVO와 속성매칭해주는 어노테이션
        log.info("api/json_insertOK.do...");
        log.info("vo: {}" , vo);

        Map<String,Object> map = new HashMap<>();
        map.put("result",1);
        return map;
    }

    @PostMapping("/json_insertOK2.do")
    public ResponseEntity<Map<String,Object>> json_insertOK2(@RequestBody TestVO vo) {
        log.info("api/json_insertOK2.do...");
        log.info("vo: {}" , vo);

        //ResponseEntity객체로 json반환가능
        Map<String,Object> map = new HashMap<>();
        try {
            map.put("result",1);
//            return new ResponseEntity<>(map, HttpStatus.OK);
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("result",-1);
            //return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    @GetMapping("/json_nicknameCheck.do")
    public Map<String,Object> json_nicknameCheck(TestVO vo) {
        log.info("api/json_nicknameCheck.do...");
        log.info("vo: {}" , vo);

        Map<String,Object> map = new HashMap<>();
        map.put("result","OK");
        return map;
    }

}
