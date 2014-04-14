package com.exercise.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;

import com.exercise.exception.ComponentNotRunningException;

public class ComponentServiceImplTest {
	
	ComponentService componentService;
	MongoDbFactory mongoDbFactory;
	
	@Before
	public void setUp() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/test/applicationContext-test.xml");
		componentService = (ComponentService)ctx.getBean("componentService");
		mongoDbFactory = (MongoDbFactory)ctx.getBean("mongoDbFactory");
		componentService.setMongo(mongoDbFactory);
	}
	
	@Test
	public void testConnect() {
		try {
			componentService.connect();
		} catch(ComponentNotRunningException e) {
			assertTrue(false);
		}
		assertTrue(true);
	}
}
