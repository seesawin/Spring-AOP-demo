package com.mycompany.app.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyService {
	private static final  Logger log = Logger.getLogger(MyService.class) ;
	
	public String setName(String name) throws Exception {
		try {
			log.info("setName is : " + name);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return "Say Hi " + name + "!";
	}
}
