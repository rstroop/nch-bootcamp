package com.rhc.lab.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class BaseMongoDao {

	private MongoClient mongoClient;
	private DB db;

	public MongoClient getMongoClient() {
		return mongoClient;
	}
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	public DB getDb() {
		return db;
	}
	public void setDb(DB db) {
		this.db = db;
	}

}
