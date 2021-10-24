package lb.cnam.c2.v1.apis.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lb.cnam.c2.v1.apis.entities.UserEducationEntity;
import lb.cnam.c2.v1.apis.entities.UserExperienceEntity;
import lb.cnam.c2.v1.apis.entities.UserSkillEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.modals.responses.web.PersonalInfoModal;
import lb.cnam.c2.v1.apis.modals.responses.web.UserProfileModal;
import lb.cnam.c2.v1.apis.services.UserService;
import lb.cnam.c2.v1.apis.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "User", tags = {"User"})
@RequestMapping(path = "/v1/user")
public final class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@ApiOperation(value="Fetch User", tags = {"User"})
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public ResponseEntity<Response> fetchUser (
		@RequestParam("userId") int userId
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.fetchUser(userId));
    	logger.debug("GET: /v1/user/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Create User", tags = {"User"})
	@RequestMapping(method = RequestMethod.PUT, path = "/")
	public ResponseEntity<Response> signup (
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		@RequestParam("email") String email,
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName,
		@RequestParam("title") String title
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.signup(username, password, email, firstName, lastName, title));
    	logger.debug("PUT: /v1/user/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Login", tags = {"User"})
	@RequestMapping(method = RequestMethod.POST, path = "/")
	public ResponseEntity<Response> login (
			@RequestParam("username") String username,
			@RequestParam("password") String password
		) {
		Response response = ResponseUtils.getSuccessResponse(userService.login(username, password));
    	logger.debug("POST: /v1/user/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Education", tags = {"User"})
	@RequestMapping(method = RequestMethod.GET, path = "/education")
	public ResponseEntity<Response> fetchUserEducation (
		@RequestParam("userId") int userId
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.fetchUserEducation(userId));
    	logger.debug("GET: /v1/user/education: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Experience", tags = {"User"})
	@RequestMapping(method = RequestMethod.GET, path = "/experience")
	public ResponseEntity<Response> fetchUserExperience (
		@RequestParam("userId") int userId
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.fetchUserExperience(userId));
    	logger.debug("GET: /v1/user/experience: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Skills", tags = {"User"})
	@RequestMapping(method = RequestMethod.GET, path = "/skills")
	public ResponseEntity<Response> fetchUserSkills (
		@RequestParam("userId") int userId
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.fetchUserSkills(userId));
    	logger.debug("GET: /v1/user/skills: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Education", tags = {"User"})
	@RequestMapping(method = RequestMethod.PUT, path = "/education")
	public ResponseEntity<Response> updateUserEducation (
			@RequestParam("userId") int userId,
			@RequestBody UserProfileModal userProfileModal
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.updateUserEducation(userId, userProfileModal.getEducation()));
    	logger.debug("PUT: /v1/user/education: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Experience", tags = {"User"})
	@RequestMapping(method = RequestMethod.PUT, path = "/experience")
	public ResponseEntity<Response> updateUserExperience (
			@RequestParam("userId") int userId,
			@RequestBody UserProfileModal userProfileModal
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.updateUserExperience(userId, userProfileModal.getExperience()));
    	logger.debug("PUT: /v1/user/experience: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Skills", tags = {"User"})
	@RequestMapping(method = RequestMethod.PUT, path = "/skills")
	public ResponseEntity<Response> updateUserSkills (
			@RequestParam("userId") int userId,
			@RequestBody UserProfileModal userProfileModal
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.updateUserSkills(userId, userProfileModal.getSkills()));
    	logger.debug("PUT: /v1/user/skills: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch User Personal Info", tags = {"User"})
	@RequestMapping(method = RequestMethod.PUT, path = "/personalInfo")
	public ResponseEntity<Response> updateUserPersonalInfo (
			@RequestParam("userId") int userId,
			@RequestBody PersonalInfoModal personalInfoModal
	) {
		Response response = ResponseUtils.getSuccessResponse(userService.updateUserPersonalInfo(userId, personalInfoModal));
    	logger.debug("PUT: /v1/user/personalInfo: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}