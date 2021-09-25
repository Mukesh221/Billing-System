package com.billingsystem.billingsystem.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
	
	
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* com.billingsystem.billingsystem.*.*.*(..) )")
	public void myPc() {
		
	}
	
	@Around("myPc()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper map = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] arr = pjp.getArgs();
		
		
		log.info("method invoked is "+ className+ " : "+methodName+ "()"
				+ ""+ "arguments : "+ map.writeValueAsString(arr));
		
		
		Object obj = pjp.proceed();
		
		//This is the response which we got from service layer
		log.info(className + " : "+methodName+ " () " + "Response : "
				+ ""+ map.writeValueAsString(obj));
		return obj;
		
		
		
	}
}
