package com.myapp.api.entities.nosql;


import java.util.List;
import org.springframework.data.annotation.Id;

/**
 * 
 * MongoDB Entity
 *
 */
public class Technology {
                                                            
    @Id
    private String id;
    private Integer userId;

    private String technologyName;
    private List<String> skillset;
    
    public Technology() {}

	public Technology(String id, String technologyName,Integer userId, List<String> skillset) {
		super();
		this.id = id;
		this.userId = userId;
		this.technologyName = technologyName;
		this.skillset = skillset;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public List<String> getSkillset() {
		return skillset;
	}

	public void setSkillset(List<String> skillset) {
		this.skillset = skillset;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}