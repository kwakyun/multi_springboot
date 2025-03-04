package org.example.boot01_hello;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class Boot01HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot01HelloApplication.class, args);
        System.out.println("Hello World!");
        //@Slf4j 어노테이션을 사용한 로그 찍기 - lombok 라이브러리
        log.info("log Hello World!");
        val name = "kim"; //immutable data variable : 수정불가별수,final
        //name = "lee";//error 수정불가
        val age = 33;
        val list = new ArrayList<String>();
        list.add(name);

        //test("yang");
        //test(null);//널값 전달 @NonNull 설정으로 오류발생시켜줄 수 있다.

        @Cleanup val scanner = new Scanner(System.in);
        //scanner.close();//@Cleanup를 사용하면 이메소드를 생략해도 자동으로 닫기 처리를 해준다

        val vo = new TestVO(11,"kim",44);
        log.info(vo.toString());
        log.info("{}",vo);
    }//end main

    private static void test(@NonNull String name) {
        log.info("name:{},{},{}", name,11,22);
    }

}//end class
