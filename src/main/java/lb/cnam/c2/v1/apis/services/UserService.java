package lb.cnam.c2.v1.apis.services;

import java.util.List;

import lb.cnam.c2.v1.apis.entities.UserEducationEntity;
import lb.cnam.c2.v1.apis.entities.UserExperienceEntity;
import lb.cnam.c2.v1.apis.entities.UserSkillEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.modals.responses.web.PersonalInfoModal;

public interface UserService {
	
	public Response signup(String username, String password, String email, String firstName, String lastName, String title);

	public Response login(String username, String password);

	public Response fetchUser(int userId);

	public Response fetchUserEducation(int userId);

	public Response fetchUserExperience(int userId);

	public Response fetchUserSkills(int userId);

	public Response updateUserEducation(int userId, List<UserEducationEntity> userEducationEntityList);

	public Response updateUserExperience(int userId, List<UserExperienceEntity> userExperienceEntityList);

	public Response updateUserSkills(int userId, List<UserSkillEntity> useSkillEntityList);

	public Response updateUserPersonalInfo(int userId, PersonalInfoModal personalInfoModal);

}
