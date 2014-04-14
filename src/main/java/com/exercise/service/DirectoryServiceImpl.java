package com.exercise.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.exercise.exception.ErrorCode;
import com.exercise.exception.InvalidDirectoryException;

public class DirectoryServiceImpl implements DirectoryService {

	@Override
	public List<String> listFileNamesInDirectory(String path) throws InvalidDirectoryException {
		List<String> fileNames = new ArrayList<String>();
		File folder = new File(path);
		File[] files = folder.listFiles();
		if (files == null) {
			throw new InvalidDirectoryException(ErrorCode.INVALID_DIRECTORY_PATH);
		}
		for (File file: files) {
			if (file.isFile()) {
				fileNames.add(file.getName());
			}
		}
		return fileNames;
	}

}
