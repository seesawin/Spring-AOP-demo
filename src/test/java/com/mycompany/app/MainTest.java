package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.service.MyService;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/application-context.xml" });
		MyService myService = (MyService) context.getBean("MyService", MyService.class);
		try {
			myService.setName("Frank");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
