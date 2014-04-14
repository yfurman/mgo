package com.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exercise.model.AuthParams;
import com.exercise.model.User;
import com.exercise.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {  
    
    @Autowired
    private UserService userService;
     
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> authenticate(@RequestBody AuthParams auth) {
    	try {
    		boolean authPassed = userService.authenticate(auth);
    		if (authPassed) {
    			return new ResponseEntity<User>(HttpStatus.OK);
    		} else {
    			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    		}
    	} catch (Exception e) {
    		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList(@RequestParam(value="gender", required=true) String gender) {
    	return userService.listUsersByGender(gender);
    }
}