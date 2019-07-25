package com.myapp.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.myapp.api.entities.nosql.Technology;
import com.myapp.api.model.TechnologyModel;

/**
 * 
 * ModelToEntity converts Models to Entities
 *
 */
public class ModelToEntity {
	
	public static List<Technology> convertTechnologyModelsToTechnologies
	(List<TechnologyModel> objects,Integer userId) {
		List<Technology> technologies = new ArrayList<>();
		objects.stream().forEach(item->{
			Technology technology = new Technology();
			technology.setUserId(userId);
			technology.setSkillset(item.getSkillset());
			technology.setTechnologyName(item.getTechnologyName());
			technologies.add(technology);
		});
		return technologies;
	}
}
