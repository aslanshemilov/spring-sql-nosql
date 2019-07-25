package com.myapp.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myapp.api.entities.nosql.Technology;
import com.myapp.api.entities.sql.User;
import com.myapp.api.mappers.EntityToModel;
import com.myapp.api.mappers.ModelToEntity;
import com.myapp.api.model.TechnologyModel;
import com.myapp.api.model.UserInfoModel;
import com.myapp.api.repository.nosql.TechnologyRepository;
import com.myapp.api.repository.sql.IUserRepository;

@Service
public class BaseService {
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	/**
	 * This methods saves data processing the Model
	 * @param infoModel
	 * @return
	 */
	public UserInfoModel createUser(UserInfoModel infoModel) {
		// User save logic in MySQL Db
		User user = new User();
		user.setEmailAddress(infoModel.getEmailAddress());
		user.setName(infoModel.getName());
		user = userRepository.save(user);
		infoModel.setUserId(user.getId());
		if(!CollectionUtils.isEmpty(infoModel.getTechnologies())) {
		 infoModel.setTechnologies(insertTechnologies(infoModel.getTechnologies(), infoModel.getUserId()));	
		}
		return infoModel;
	}
	/**
	 * Private Method used in createUser Method
	 * @param objects
	 * @param userId
	 * @return
	 */
	private List<TechnologyModel> insertTechnologies(List<TechnologyModel> objects,Integer userId){
		// Save Logic for Technologies for MongoDb
		List<TechnologyModel> technologyModels = new ArrayList<>();
		List<Technology> technologies = ModelToEntity.convertTechnologyModelsToTechnologies(objects,userId);
		technologies = technologyRepository.saveAll(technologies);
		technologyModels = EntityToModel.convertTechnologiesToTechnologyModels(technologies);
		return technologyModels;
	}
	
	/**
	 * This methods reads data processing the entities
	 * @param infoModel
	 */
	public List<UserInfoModel> getUsersList(){
		List<UserInfoModel> userInfoModels = new ArrayList<UserInfoModel>();
		// Retrieving List of Users from MySQL Database
		List<User> users = userRepository.findAll();
		if(!CollectionUtils.isEmpty(users)) {
			users.stream().forEach(item->{
				UserInfoModel uModel = new UserInfoModel();
				uModel.setUserId(item.getId());
				uModel.setName(item.getName());
				uModel.setEmailAddress(item.getEmailAddress());
				// Retrieving List of Technologies from MongoDB Database
				List<Technology> technologies = technologyRepository.findByUserId(item.getId());
				if(!CollectionUtils.isEmpty(technologies)) {
					uModel.setTechnologies(EntityToModel.convertTechnologiesToTechnologyModels(technologies));
				}
				userInfoModels.add(uModel);
			});
		}
		return userInfoModels;
	}

}
