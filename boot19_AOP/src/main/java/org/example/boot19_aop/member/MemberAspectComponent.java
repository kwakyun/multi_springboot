package org.example.boot19_aop.member;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect       //의존성 : implementation 'org.springframework.boot:spring-boot-starter-aop'
@Component    // 컴포넌트로 반드시 등록하거나 ,@Bean으로 등록해야함.
public class MemberAspectComponent{

    //모든 서비스클래스의 selectAll메소드를 포인트 컷으로 설정
//    @Around("execution(public * org..*Service*.selectAll(..))")
    //Member 서비스클래스의 selectAll 메소드를 포인트 컷으로 설정
    @Around("execution(public * org..MemberService*.selectAll(..))")
    public Object testAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("testAroundAdvice()...before..proceed");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); //실제실행되는 selectAll메소드
        long executionTime = System.currentTimeMillis() - start;
        log.info("testAroundAdvice()...after..proceed");
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }

    //모든 서비스클래스의 selectAll메소드를 포인트 컷으로 설정
//    @Around("execution(public * org..*Service*.selectAll(..))")
    //Member 서비스클래스의 selectAll 메소드를 포인트 컷으로 설정
    @Around("execution(public * org..MemberMapper*.selectOne(..))")
    public Object aroundSelectOne(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("aroundSelectOne()...before..proceed");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(); //실제실행되는 selectAll메소드
        long executionTime = System.currentTimeMillis() - start;
        log.info("aroundSelectOne()...after..proceed");
        log.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
    //포인트컷 하나 설정해서 여러군데 쓰고싶을때
    @Pointcut("execution(public * org..MemberService*.updateOK(..))")
    public void selectAllPointCut() {//설정만을 위한 메소드
        log.info("selectAllPointCut()....");//실행문이 수행되지않는다.
    }
    @Before("selectAllPointCut()")
    public void testBeforeAdvice(JoinPoint joinPoint) {
        log.info("testBeforeAdvice()...{}",joinPoint.getSignature());
    }
    @After("selectAllPointCut()")
    public void testAfterAdvice(JoinPoint joinPoint) {
        log.info("testAfterAdvice()...{}",joinPoint.getSignature());
    }
}//end class
