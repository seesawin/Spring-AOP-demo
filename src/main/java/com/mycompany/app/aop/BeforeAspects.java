package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspects {
	private static final  Logger log = Logger.getLogger(BeforeAspects.class) ;
	
	@Before("com.mycompany.app.aop.SystemPointcuts.before()")
	public void execBefore() throws Throwable {
		log.info("@Before");
	}

}
