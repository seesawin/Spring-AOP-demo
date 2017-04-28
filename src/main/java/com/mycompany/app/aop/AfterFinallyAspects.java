package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterFinallyAspects {
	private static final  Logger log = Logger.getLogger(AfterFinallyAspects.class) ;

    @After("com.mycompany.app.aop.SystemPointcuts.afterFinal()")
    public void execAfterFinal() {
    	log.info(" @After");
    }

}
