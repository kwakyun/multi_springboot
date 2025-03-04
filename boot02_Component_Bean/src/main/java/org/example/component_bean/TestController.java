package org.example.component_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class TestController  implements ApplicationRunner {
    @Autowired
    TestService testService;

    @Autowired
    TestBean testBean;

    @Autowired
    Person person;

    @Autowired
    MemberService memberService;

    @Autowired
    Student student;

    public TestController() {
        log.info("TestController ...");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("..run()...");
        testService.start();
        testBean.stop();
        //미션1 : Person(속성-{name,age},기능-sleep()) 를 빈으로 등록하고 호출하기.
        person.sleep();
        log.info("{}",person);

        // 미션2.
        // MemberService(insert(MemberVO)),
        // MemberDAO(insert(MemberVO)),MemberDAOimpl(insert(MemberVO))
        // 여기서 출력로그...
        MemberVO vo = new MemberVO();
        vo.setNum(1);
        vo.setId("admin");
        vo.setPw("hi1111");
        vo.setName("kim");
        vo.setTel("011");
        log.info("result:{}",memberService.insert(vo));

        //Student 객체 정보확인
        log.info("student : {}",student);
    }
}
