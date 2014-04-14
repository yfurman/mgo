package com.exercise.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.exercise.model.AuthParams;
import com.exercise.model.User;

@Repository
public class UserDaoImpl implements UserDao {
     
    @Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "User";
     
    public void addUser(User user) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }       
        user.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(user, COLLECTION_NAME);
    }
     
    public List<User> listAllUsers() {
        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
    }
    
    public boolean authenticate(AuthParams args) {
    	Criteria criteria = Criteria.where("auth.username").is(args.getUsername())
    							.and("auth.password").is(args.getPassword());
    	Query query = new Query(criteria);
    	User user = mongoTemplate.findOne(query, User.class);
    	return (user != null);
    }
    
    public List<User> listUsersByGender(String gender) {
    	Query query = new Query();
    	query.addCriteria(Criteria.where("gender").is(gender));
    	return mongoTemplate.find(query, User.class);
    }
     
    public void deleteUser(User User) {
        mongoTemplate.remove(User, COLLECTION_NAME);
    }
     
    public void updateUser(User User) {
        mongoTemplate.insert(User, COLLECTION_NAME);      
    }
    
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
    	this.mongoTemplate = mongoTemplate;
    }
}