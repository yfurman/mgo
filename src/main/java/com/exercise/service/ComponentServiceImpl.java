package com.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;

import com.exercise.exception.ComponentNotRunningException;
import com.exercise.exception.ErrorCode;
import com.mongodb.DB;
import com.mongodb.MongoException;

public class ComponentServiceImpl implements ComponentService {
	
	@Autowired
	private MongoDbFactory mongo;

	@Override
	public void connect() throws ComponentNotRunningException {
		try {
			DB db = mongo.getDb();
			db.getStats();
		} catch (MongoException e) {
	        throw new ComponentNotRunningException(ErrorCode.MONGO_IS_DOWN);
	    }
	}

	public void setMongo(MongoDbFactory mongo) {
		this.mongo = mongo;
	}
}
