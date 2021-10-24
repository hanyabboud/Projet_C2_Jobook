package lb.cnam.c2.v1.apis.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lb.cnam.c2.v1.apis.adapter.UserAdapter;
import lb.cnam.c2.v1.apis.entities.UserEducationEntity;
import lb.cnam.c2.v1.apis.entities.UserEntity;
import lb.cnam.c2.v1.apis.entities.UserExperienceEntity;
import lb.cnam.c2.v1.apis.entities.UserSkillEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.modals.responses.web.PersonalInfoModal;
import lb.cnam.c2.v1.apis.modals.responses.web.UserModal;
import lb.cnam.c2.v1.apis.utils.AESencrp;
import lb.cnam.c2.v1.repositories.UserEducationEntityRepository;
import lb.cnam.c2.v1.repositories.UserEntityRepository;
import lb.cnam.c2.v1.repositories.UserExperienceEntityRepository;
import lb.cnam.c2.v1.repositories.UserSkillEntityRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserEducationEntityRepository userEducationEntityRepository;
	
	@Autowired
	private UserExperienceEntityRepository userExperienceEntityRepository;
	
	@Autowired
	private UserSkillEntityRepository userSkillEntityRepository;
	
	@Override
	public Response signup(String username, String password, String email, String firstName, String lastName, String title) {
		Response response = null;
		try {
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			// Create User Entity
			UserEntity user = new UserEntity();
			user.setUsername(username);
			user.setPassword(AESencrp.encrypt(password));
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setTitle(title);
			user.setCreationDate(creationDate);
			
			// Save User Entity
			UserEntity userEntity = userEntityRepository.save(user);
			
			// Build User Modal
			UserModal userModal = UserAdapter.build(userEntity);
			
			// Create Success Response
			response = new Response(true, "[User] Create Success", userModal);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public Response login(String username, String password) {
		Response response = null;
		try {
			UserEntity user = null;
			
			// Fetch User Entity
			UserEntity userEntity = userEntityRepository.findByUsername(username);
			
			// Check if User Exists and password matches
			if(userEntity != null && userEntity.getPassword().equalsIgnoreCase(AESencrp.encrypt(password))) {
				user = userEntity;
			}
			
			// Send Invalid User Response
			if(user == null) {
				response = new Response(false, "Invalid username or password.");
				return response;
			}
			
			// Build User Modal
			UserModal userModal = UserAdapter.build(userEntity);
			
			// Create Success Response
			response = new Response(true, "[User] Login Success", userModal);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response fetchUser(int userId) {
		Response response = null;
		try {
			// Fetch User Entity
			UserEntity userEntity = userEntityRepository.findByUserId(userId);
			
			// Send Invalid User Response
			if(userEntity == null) {
				// Create Fail Response
				response = new Response(false, "Invalid User ID.");
				return response;
			}
			
			// Build User Modal
			UserModal userModal = UserAdapter.build(userEntity);
			
			// Create Success Response
			response = new Response(true, "[User] User Fetched Successfully.", userModal);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response fetchUserEducation(int userId) {
		Response response = null;
		try {
			// Fetch User Education Entities
			List<UserEducationEntity> userEducationEntityList = userEducationEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Education List Fetched Successfully.", userEducationEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response fetchUserExperience(int userId) {
		Response response = null;
		try {
			// Fetch User Experience Entities
			List<UserExperienceEntity> userExperienceEntityList = userExperienceEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Experience List Fetched Successfully.", userExperienceEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response fetchUserSkills(int userId) {
		Response response = null;
		try {
			// Fetch User Skill Entities
			List<UserSkillEntity> userSkillEntityList = userSkillEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Skill List Fetched Successfully.", userSkillEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response updateUserEducation(int userId, List<UserEducationEntity> userEducationEntityList) {
		Response response = null;
		try {
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			// Set User Id and Creation Date for List
			for(int i=0;i<userEducationEntityList.size();i++) {
				UserEducationEntity userEducationEntity = userEducationEntityList.get(i);
				userEducationEntity.setUserId(userId);
				userEducationEntity.setCreationDate(creationDate);
			}
						
			// Delete User Education Entities
			userEducationEntityRepository.deleteByUserId(userId);
			
			// Save User Education Entities
			userEducationEntityRepository.saveAll(userEducationEntityList);
			
			// Fetch User Education Entities
			userEducationEntityList = userEducationEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Education List Updated Successfully.", userEducationEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response updateUserExperience(int userId, List<UserExperienceEntity> userExperienceEntityList) {
		Response response = null;
		try {
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

			// Set User Id and Creation Date for List
			for(int i=0;i<userExperienceEntityList.size();i++) {
				UserExperienceEntity userExperienceEntity = userExperienceEntityList.get(i);
				userExperienceEntity.setUserId(userId);
				userExperienceEntity.setCreationDate(creationDate);
			}
						
			// Delete User Experience Entities
			userExperienceEntityRepository.deleteByUserId(userId);
			
			// Save User Experience Entities
			userExperienceEntityRepository.saveAll(userExperienceEntityList);
			
			// Fetch User Experience Entities
			userExperienceEntityList = userExperienceEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Experience List Updated Successfully.", userExperienceEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response updateUserSkills(int userId, List<UserSkillEntity> userSkillEntityList) {
		Response response = null;
		try {
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

			// Set User Id and Creation Date for List
			for(int i=0;i<userSkillEntityList.size();i++) {
				UserSkillEntity userSkillEntity = userSkillEntityList.get(i);
				userSkillEntity.setUserId(userId);
				userSkillEntity.setCreationDate(creationDate);
			}
			
			// Delete User Skill Entities
			userSkillEntityRepository.deleteByUserId(userId);
			
			// Save User Skill Entities
			userSkillEntityRepository.saveAll(userSkillEntityList);
			
			// Fetch User Skill Entities
			userSkillEntityList = userSkillEntityRepository.findByUserId(userId);
			
			// Create Success Response
			response = new Response(true, "[User] User Skill List Updated Successfully.", userSkillEntityList);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response updateUserPersonalInfo(int userId, PersonalInfoModal personalInfoModal) {
		Response response = null;
		try {
			// Fetch User Entity
			UserEntity userEntity = userEntityRepository.findByUserId(userId);
			
			// Send Invalid User Response
			if(userEntity == null) {
				// Create Fail Response
				response = new Response(false, "Invalid User ID.");
				return response;
			}
			
			userEntity.setFirstName(personalInfoModal.getFirstName());
			userEntity.setLastName(personalInfoModal.getLastName());
			userEntity.setEmail(personalInfoModal.getEmail());
			userEntity.setTitle(personalInfoModal.getTitle());

			// Update User in DB
			userEntityRepository.save(userEntity);
			
			// Fetch User Entity After Save
			userEntity = userEntityRepository.findByUserId(userId);
						
			// Build User Modal
			UserModal userModal = UserAdapter.build(userEntity);
			
			// Create Success Response
			response = new Response(true, "[User] User Personal Info Updated Successfully.", userModal);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
}