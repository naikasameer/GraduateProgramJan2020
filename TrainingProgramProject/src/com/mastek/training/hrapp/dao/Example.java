package com.mastek.training.hrapp.dao;

import org.bson.Document;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Grades;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Example {
	
	public static void main(String[] args) {
		MongoClient c = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = c.getDatabase("graduate_2020_masteknet");
		MongoCollection<Document> coll = database.getCollection("employees");
		
		
		Document build = new Document();
		build.put("empno", 12);
		build.put("name", "asa");
		build.put("unit-salary",2333.0);
		build.put("grade", Grades.G10.toString());
		build.put("designation",Designations.ARCHITECT.toString());
		
		coll.insertOne(build);

		//coll.deleteOne(new Document("empno", 12));
		
		for (Document obj : coll.find(new Document("empno",12))) {
			System.out.println(obj.toJson());
		}
		
		
		
		

	}

}
