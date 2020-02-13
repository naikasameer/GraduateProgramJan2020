package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPostion;

@Repository // mark the class as repository
public interface JobPositionDAO extends 
		MongoRepository<JobPostion, Integer>{
	//	map the Document and Identifier type with MongoRepository 

}
