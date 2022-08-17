package com.swan.springbootdev.demo.aop;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);
	
	//@Pointcut : AOP를 적용할 특정 범위(패키지, 클래스, 메서드) 설정
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }
	
	//@Before : 지정 메서드 실행 전 동작
	@Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("@Before : Logging start");
        LOGGER.info("@Before : Logging end");
    }
    
	//@AfterReturning : 지정 메서드 실행 후 값을 리턴할 때 동작
    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("@AfterReturning : Logging start");
        LOGGER.info("@AfterReturning : Logging end");
        LOGGER.info("@AfterReturning : result : "+result.toString());
    }
    
    //@Around : 지정 메서드 실행 전, 실행 후 둘다 지정 가능
    @Around("GetMapping()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("@Around : Logging start");
        try {
            Object result = joinPoint.proceed();
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            LOGGER.info("className:"+className);
            LOGGER.info("methodName:"+methodName);
            LOGGER.info("@Around : Logging end");
            return result;
        }catch (Exception e) {
            LOGGER.error("@Around : Exception");
            LOGGER.error(e.toString());
            return null;
        }
    }
}
