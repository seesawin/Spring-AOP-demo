package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemPointcuts {
	private static final Logger log = Logger.getLogger(SystemPointcuts.class);

	@Pointcut("within(com.mycompany.app.service..*)")
	public void before() {}

	@Before("before()")
	public void execBefore() throws Throwable {
		log.info("*@Before");
	}
	
	@Pointcut("within(com.mycompany.app.service..*)")
	public void afterFinal() {}
	
	@After("afterFinal()")
    public void execAfterFinal() {
    	log.info("*@After");
    }

	@Pointcut("within(com.mycompany.app.service..*)")
	public void afterRet() {}

	@AfterReturning("afterRet()")
	public void execAfterRet() {
		log.info("*@AfterReturning");
	}

	@AfterReturning(pointcut = "afterRet()", returning = "retVal")
	public void execAfterRetVal(Object retVal) {
		log.info("*@AfterReturning : " + retVal);
	}

	@Pointcut("within(com.mycompany.app.service..*)")
	public void afterThrowing() {}
	
	@AfterThrowing("afterThrowing()")
    public void execAfterThrowing() {
    	log.info("*@AfterThrowing");
    }
    
    @AfterThrowing(
            pointcut="afterThrowing()",
            throwing="ex")
    public void execAfterThrowing(Exception ex) {
    	log.info("*@AfterThrowing Exception ex : " + ex.getMessage());
    }

	@Pointcut("within(com.mycompany.app.service..*)")
	public void around() {}

	@Around("around()")
	public Object execAround(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("*@Around start");

		Object[] args = pjp.getArgs();
		
		for(int i = 0; i < args.length; i++) {
			log.info("args[" + i + "] : " + args[i]);
			log.info("reset Hsu");
			args[i] = "Hsu ";
		}
		
		String component = pjp.getSignature().getDeclaringType().getName();
		String method = pjp.getSignature().getName();

		log.info("component : " + component);
		log.info("invoke method : " + method);
		
		Object resp = pjp.proceed(args);
		log.info("resp : " + resp);
		
		log.info("*@Around end");

		return resp;
	}
}
