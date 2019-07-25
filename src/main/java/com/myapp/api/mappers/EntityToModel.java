package com.myapp.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.myapp.api.entities.nosql.Technology;
import com.myapp.api.model.TechnologyModel;

/**
 * 
 * EntityToModel converts Entities to Models
 *
 */
public class EntityToModel {
	
	public static List<TechnologyModel> convertTechnologiesToTechnologyModels(List<Technology> technologies) {
		List<TechnologyModel> technologyModels = new ArrayList<TechnologyModel>();
		technologies.forEach(item->{
			TechnologyModel technologyModel = new TechnologyModel();
			technologyModel.setTechId(item.getId());
			technologyModel.setTechnologyName(item.getTechnologyName());
			technologyModel.setSkillset(item.getSkillset());
			technologyModels.add(technologyModel);
		});
		return technologyModels;
	}

}
