package com.exercise.service;

import java.util.List;

import com.exercise.model.AuthParams;
import com.exercise.model.User;

public interface UserService {
    
	void addUser(User User);
    
    boolean authenticate(AuthParams auth);
     
    List<User> listUsersByGender(String gender);
     
    void deleteUser(User user);
     
    void updateUser(User user);
}
