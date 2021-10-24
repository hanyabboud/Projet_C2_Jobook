package lb.cnam.c2.v1.apis.controllers;

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

import lb.cnam.c2.v1.apis.entities.JobEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.services.JobService;
import lb.cnam.c2.v1.apis.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Job", tags = {"Job"})
@RequestMapping(path = "/v1/job")
public final class JobController {
	
	Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private JobService jobService;
	
	@CrossOrigin
	@ApiOperation(value="Fetch Jobs By Enum", tags = {"Job"})
	@RequestMapping(method = RequestMethod.POST, path = "/")
	public ResponseEntity<Response> fetchJobsByEnum (
			@RequestBody String body,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "jobEnum", required = true) int jobEnum
		) {
		Response response = ResponseUtils.getSuccessResponse(jobService.fetchJobsByEnum(body, search, jobEnum));
    	logger.debug("GET: /v1/job/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Fetch Jobs By User", tags = {"Job"})
	@RequestMapping(method = RequestMethod.POST, path = "/user")
	public ResponseEntity<Response> fetchJobsByUser (
			@RequestParam("userId") int userId
		) {
		Response response = ResponseUtils.getSuccessResponse(jobService.fetchJobsByUser(userId));
    	logger.debug("GET: /v1/job/user: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Create Job", tags = {"Job"})
	@RequestMapping(method = RequestMethod.PUT, path = "/")
	public ResponseEntity<Response> createJob (
			@RequestBody JobEntity job
		) {
		Response response = ResponseUtils.getSuccessResponse(jobService.createJob(job));
    	logger.debug("PUT: /v1/job/user: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Delete Job", tags = {"Job"})
	@RequestMapping(method = RequestMethod.DELETE, path = "/")
	public ResponseEntity<Response> deleteJob (
			@RequestParam("jobId") int jobId
		) {
		Response response = ResponseUtils.getSuccessResponse(jobService.deleteJob(jobId));
    	logger.debug("DELETE: /v1/job/user: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}