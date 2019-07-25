package com.myapp.api.repository.nosql;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.api.entities.nosql.Technology;

public interface TechnologyRepository extends MongoRepository<Technology, String> {
	
	List<Technology> findByUserId(Integer userId);

}
