package com.ashyleika.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	@Pointcut("execution(* com.ashyleika.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.ashyleika.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.ashyleika.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint jp) {
		String method = jp.getSignature().toShortString();
		logger.info("=======>>>> in @Before: calling method: " + method);
		
		Object[] args = jp.getArgs();
		for(Object arg:args) {
			logger.info("=======>>>>> Argument: " + arg.toString());
		}
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturningAdvice(JoinPoint jp, Object theResult) {
		String method = jp.getSignature().toShortString();
		logger.info("=======>>>>> in @AfterReturning: calling method: " + method);
		logger.info("=======>>>>> result: " + theResult.toString());
	}
		
}





















