package com.myapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.api.model.UserInfoModel;
import com.myapp.api.service.BaseService;

@RestController
@RequestMapping("/api")
public class BaseController {
	
	@Autowired
	BaseService baseService;
	
	/**
	 * This API saves data in both databases
	 * @param infoModel
	 * @return
	 */
	@PostMapping("/users")
	public ResponseEntity<UserInfoModel> createUser(@RequestBody UserInfoModel infoModel) {
		return new ResponseEntity<UserInfoModel>(baseService.createUser(infoModel),HttpStatus.CREATED);
	}
	
	/**
	 * This API reads data from both databases
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<List<UserInfoModel>> getUsers() {
		List<UserInfoModel> userInfoModels = baseService.getUsersList();
		if(CollectionUtils.isEmpty(userInfoModels)) {
			return new ResponseEntity<List<UserInfoModel>>(baseService.getUsersList(),HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<UserInfoModel>>(baseService.getUsersList(),HttpStatus.OK);
		}
	}
	
	

}
