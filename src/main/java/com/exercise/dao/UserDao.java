package com.exercise.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.exercise.model.AuthParams;
import com.exercise.model.User;

public interface UserDao {
    void addUser(User User);
     
    List<User> listAllUsers();
    
    boolean authenticate(AuthParams args);
    
    List<User> listUsersByGender(String gender);
     
    void deleteUser(User User);
     
    void updateUser(User user);
    
    void setMongoTemplate(MongoTemplate mongoTemplate);
}
