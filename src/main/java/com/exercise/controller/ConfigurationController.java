package com.exercise.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.exception.ComponentNotRunningException;
import com.exercise.exception.ErrorCode;
import com.exercise.exception.InvalidDirectoryException;
import com.exercise.model.ComponentStatus;
import com.exercise.service.ComponentService;
import com.exercise.service.DirectoryService;

@Controller
@RequestMapping("/configuration")
public class ConfigurationController {
	
	private static final Logger LOGGER = Logger
            .getLogger(ConfigurationController.class);
    
    @Autowired
    private DirectoryService directoryService;
    @Autowired
    private ComponentService componentService;
    
    @ResponseBody
    @RequestMapping(value="/components", method = RequestMethod.GET)
    public List<ComponentStatus> getComponentStatuses() {
    	List<ComponentStatus> statuses = new ArrayList<ComponentStatus>();
    	try {
    		componentService.connect();
			statuses.add(new ComponentStatus("mongo", HttpStatus.OK));
    	} catch (ComponentNotRunningException e) {
    		if (e.getErrorCode().equals(ErrorCode.MONGO_IS_DOWN)) {
    			LOGGER.info("mongodb is not running", e);
    			statuses.add(new ComponentStatus("mongo", HttpStatus.SERVICE_UNAVAILABLE));
    		} else {
    			statuses.add(new ComponentStatus("server", HttpStatus.INTERNAL_SERVER_ERROR));
    		}
    	}
    	return statuses;
    }
    
    @ResponseBody
    @RequestMapping(value="/files", method = RequestMethod.GET)
    public List<String> getFilesInDirectory(@RequestParam(value="path", required=true) String path) {
    	try {
    		List<String> fileNames = directoryService.listFileNamesInDirectory(path);
    		return fileNames;
    	} catch (InvalidDirectoryException e) {
    		LOGGER.info("the provided directory path " + path + " is invalid", e);
    		return new ArrayList<String>();
    	}
    }
}