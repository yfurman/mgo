package com.exercise.service;

import org.springframework.data.mongodb.MongoDbFactory;

import com.exercise.exception.ComponentNotRunningException;

public interface ComponentService {
	void connect() throws ComponentNotRunningException;
	
	void setMongo(MongoDbFactory mongo);
}
