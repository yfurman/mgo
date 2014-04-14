package com.exercise.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.exercise.exception.InvalidDirectoryException;

public class DirectoryServiceImplTest {
	
	DirectoryService directoryService;
	
	@Before
	public void setUp() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/test/applicationContext-test.xml");
		directoryService = (DirectoryService)ctx.getBean("directoryService");
	}
	
	@Test
	public void testGetFileNamesInDirectory() {
		String path = "/Users/eugenefurman/Documents";
		List<String> fileNames = directoryService.listFileNamesInDirectory(path);
		assertNotNull(fileNames);
		assertTrue(fileNames.size() > 0);
	}
	
	@Test(expected=InvalidDirectoryException.class)
	public void testGetFileNamesInInvalidDirectory() {
		String path = "/Users/eugenefurman/Documents/2222";
		List<String> fileNames = directoryService.listFileNamesInDirectory(path);
	}	
}
