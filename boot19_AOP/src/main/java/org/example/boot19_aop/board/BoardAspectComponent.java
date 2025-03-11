package org.example.boot19_aop.board;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect       //의존성 : implementation 'org.springframework.boot:spring-boot-starter-aop'
@Component    // 컴포넌트로 반드시 등록하거나 ,@Bean으로 등록해야함.
public class BoardAspectComponent {

    //모든 서비스클래스의 selectAll메소드를 포인트 컷으로 설정
//    @Around("execution(public * org..*Service*.selectAll(..))")
    //Member 서비스클래스의 selectAll 메소드를 포인트 컷으로 설정
    @Around("execution(public * org..BoardMapper*.selectOne(..))")
    public Object testAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("testAroundAdvice()...before..proceed");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); //실제실행되는 selectAll메소드
        long executionTime = System.currentTimeMillis() - start;
        log.info("testAroundAdvice()...after..proceed");
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
    @Around("execution(public * org..BoardService*.insertOK(..))")
    public Object aroundinsertOK(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("aroundinsertOK()...before..proceed");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); //실제실행되는 selectAll메소드
        long executionTime = System.currentTimeMillis() - start;
        log.info("aroundinsertOK()...after..proceed");
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }


}//end class
