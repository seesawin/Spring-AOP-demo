package com.mycompany.app.action;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.app.BaseTest;
import com.mycompany.app.service.MyService;

public class JunitTestAction extends BaseTest{
	private static final  Logger log = Logger.getLogger(JunitTestAction.class) ;
	
	@Autowired
	public MyService myService;
	
	@Before
	public void setUp() throws Exception {
		log.info("<Junit> @Before");
	}

	@After
	public void tearDown() throws Exception {
		log.info("<Junit> @After");
	}
	
	@Test
	public void test() {
		log.info("<Junit> @Test");
		try {
			myService.setName("Frank");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
