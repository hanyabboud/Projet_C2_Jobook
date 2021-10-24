package lb.cnam.c2.v1.apis.modals.responses.web;

import java.util.List;

import lb.cnam.c2.v1.apis.entities.UserEducationEntity;
import lb.cnam.c2.v1.apis.entities.UserExperienceEntity;
import lb.cnam.c2.v1.apis.entities.UserSkillEntity;

public class UserProfileModal {

	private List<UserExperienceEntity> experience;

	private List<UserEducationEntity> education;
	
	private List<UserSkillEntity> skills;

	public List<UserExperienceEntity> getExperience() {
		return experience;
	}

	public void setExperience(List<UserExperienceEntity> experience) {
		this.experience = experience;
	}

	public List<UserEducationEntity> getEducation() {
		return education;
	}

	public void setEducation(List<UserEducationEntity> education) {
		this.education = education;
	}

	public List<UserSkillEntity> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkillEntity> skills) {
		this.skills = skills;
	}

}