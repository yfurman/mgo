package com.exercise.service;

import java.util.List;

import com.exercise.exception.InvalidDirectoryException;

public interface DirectoryService {
	List<String> listFileNamesInDirectory(String directory) throws InvalidDirectoryException;
}
