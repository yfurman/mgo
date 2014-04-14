package com.exercise.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.exercise.model.AuthParams;
import com.exercise.model.User;

public class UserDaoImplTest {
	
	UserDao userDao;
	MongoTemplate mongoTemplate;
	
	@Before
	public void setUp() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/test/applicationContext-test.xml");
		userDao = (UserDao)ctx.getBean("userDao");
		mongoTemplate = (MongoTemplate)ctx.getBean("mongoTemplate");
		userDao.setMongoTemplate(mongoTemplate);
	}
	
	@Test
	public void testAddUser() {
		AuthParams auth = new AuthParams("emp2", "pass1234");
		User user = new User();
		user.setAuth(auth);
		user.setRole("vendor");
		user.setGender("male");
		
		userDao.addUser(user);
	}
	
	@Test
	public void testGetAllUsers() {
		List<User> users = userDao.listAllUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testUsersByGender() {
		List<User> users = userDao.listUsersByGender("male");
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testAuthenticate() {
		AuthParams auth = new AuthParams("eugene", "rubik");
		boolean isAuthenticated = userDao.authenticate(auth);
		assertTrue(isAuthenticated);
	}
	
}
