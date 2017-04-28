package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAspects {
	private static final  Logger log = Logger.getLogger(AfterReturningAspects.class) ;

	@AfterReturning("com.mycompany.app.aop.SystemPointcuts.afterRet()")
	public void execAfterRet() {
		log.info("@AfterReturning");
	}

	@AfterReturning(pointcut = "com.mycompany.app.aop.SystemPointcuts.afterRet()", returning = "retVal")
	public void execAfterRetVal(Object retVal) {
		log.info("@AfterReturning : " + retVal);
	}
	
}
