package org.spring.boot.app.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	
	@Before("execution(* org.spring.boot.app.test.*.checkout())")
	public void beforeLogger() {
		System.out.println("This is before logging aspect");
	}
	
	
	@After("execution(* org.spring.boot.app.test.*.checkout())")
//	@After("execution(* *.*.checkout())")
	public void afterLogger() {
		System.out.println("This is after logging aspect");
	}
	
}
