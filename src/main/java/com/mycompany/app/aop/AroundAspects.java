package com.mycompany.app.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspects {
	private static final  Logger log = Logger.getLogger(AroundAspects.class) ;

	@Around("com.mycompany.app.aop.SystemPointcuts.around()")
	public Object execAround(ProceedingJoinPoint pjp) throws Throwable {
		log.info("@Around start");

		Object[] args = pjp.getArgs();
		
		for(int i = 0; i < args.length; i++) {
			log.info("args[" + i + "] : " + args[i]);
			log.info("reset seesawin");
			args[i] = "seesawin ";
		}
		
		String component = pjp.getSignature().getDeclaringType().getName();
		String method = pjp.getSignature().getName();

		log.info("component : " + component);
		log.info("invoke method : " + method);
		
		Object resp = pjp.proceed(args);
		log.info("resp : " + resp);
		
		log.info("@Around end");

		return resp;
	}
}
