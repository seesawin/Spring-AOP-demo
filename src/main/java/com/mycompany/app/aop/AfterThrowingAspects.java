package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAspects {
	private static final  Logger log = Logger.getLogger(AfterThrowingAspects.class) ;

    @AfterThrowing("com.mycompany.app.aop.SystemPointcuts.afterThrowing()")
    public void execAfterThrowing() {
    	log.info("@AfterThrowing");
    }
    
    @AfterThrowing(
            pointcut="com.mycompany.app.aop.SystemPointcuts.afterThrowing()",
            throwing="ex")
    public void execAfterThrowing(Exception ex) {
    	log.info("@AfterThrowing Exception ex : " + ex.getMessage());
    }

}
