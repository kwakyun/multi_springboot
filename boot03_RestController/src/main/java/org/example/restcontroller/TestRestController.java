package org.example.restcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TestRestController {



//    @GetMapping("api/json_selectOne.do")
//    public String json_selectOne(int num) {
//        log.info("api/json_selectOne.do...");
//        log.info("num: " + num);
//
//        //{"name":"kim","age":33}
//        return "{\"name\":\"kim\",\"age\":33}";
//    }

//    @GetMapping("api/json_selectOne.do")
//    public String json_selectOne(TestVO vo) {
//        log.info("api/json_selectOne.do...");
//        log.info("vo: {}" , vo);
//
//        //{"name":"kim","age":33}
//        return "{\"name\":\"kim\",\"age\":33}";
//    }

    //@ResponseBody //@RestController에서는 생략되어있다.
    @GetMapping("api/json_selectOne.do")
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

//    @GetMapping("api/json_selectAll.do")
//    public String json_selectAll() {
//        log.info("api/json_selectAll.do...");
//
//        //[{"name":"kim1","age":11},{"name":"kim2","age":22}]
//        return "[{\"name\":\"kim1\",\"age\":11},{\"name\":\"kim2\",\"age\":22}]";
//    }

    @GetMapping("api/json_selectAll.do")
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

//    @GetMapping("api/json_searList.do")
//    public String json_searList(String searchKey,String searchWord) {
//        log.info("api/json_searList.do...");
//        log.info("searchKey: " + searchKey);
//        log.info("searchWord: " + searchWord);
//
//        //[{"name":"kim1","age":11},{"name":"kim2","age":22}]
//        return "[{\"name\":\"kim1\",\"age\":11},{\"name\":\"kim2\",\"age\":22}]";
//    }

    @GetMapping("api/json_searList.do")
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

//    @GetMapping("api/json_insertOK.do")
//    public String json_insertOK(String name,int age) {
//        log.info("api/json_insertOK.do...");
//        log.info("name: " + name);
//        log.info("age: " + age);
//
//        //{"result":1}
//        return "{\"result\":1}";
//    }

//    @GetMapping("api/json_insertOK.do")
//    public String json_insertOK(TestVO vo) {
//        log.info("api/json_insertOK.do...");
//        log.info("vo: {}" , vo);
//
//        //{"result":1}
//        return "{\"result\":1}";
//    }

    @GetMapping("api/json_insertOK.do")
    public Map<String,Object> json_insertOK(/*@RequestBody*/ TestVO vo) {
        //@RequestBody : 서블릿 요청시 파라메터가 JSON객체로 넘어올때 TestVO와 속성매칭해주는 어노테이션
        log.info("api/json_insertOK.do...");
        log.info("vo: {}" , vo);

        Map<String,Object> map = new HashMap<>();
        map.put("result",1);
        return map;
    }

//    @GetMapping("api/json_nicknameCheck.do")
//    public String json_nicknameCheck(String nickname) {
//        log.info("api/json_nicknameCheck.do...");
//        log.info("nickname: " + nickname);
//
//        //{"result":"OK"}
//        return "{\"result\":\"OK\"}";
//    }

//    @GetMapping("api/json_nicknameCheck.do")
//    public String json_nicknameCheck(TestVO vo) {
//        log.info("api/json_nicknameCheck.do...");
//        log.info("vo: {}" , vo);
//
//        //{"result":"OK"}
//        return "{\"result\":\"OK\"}";
//    }

    @GetMapping("api/json_nicknameCheck.do")
    public Map<String,Object> json_nicknameCheck(TestVO vo) {
        log.info("api/json_nicknameCheck.do...");
        log.info("vo: {}" , vo);

        Map<String,Object> map = new HashMap<>();
        map.put("result","OK");
        return map;
    }

}
