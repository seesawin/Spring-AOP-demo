package com.mycompany.app;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/application-context.xml" })
public class BaseTest {
	
	private static final  Logger log = Logger.getLogger(BaseTest.class) ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.info("<Junit> @BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("<Junit> @BeforeClass");
	}
}
