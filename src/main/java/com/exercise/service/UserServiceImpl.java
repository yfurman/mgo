package com.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.dao.UserDao;
import com.exercise.model.AuthParams;
import com.exercise.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
    public void addUser(User User) {
        userDao.addUser(User);
    }
    
    public boolean authenticate(AuthParams auth) {
    	return userDao.authenticate(auth);
    }
     
    public List<User> listUsersByGender(String gender) {
        return userDao.listUsersByGender(gender);
    }
     
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
     
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
