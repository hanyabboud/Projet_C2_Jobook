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

import lb.cnam.c2.v1.apis.entities.CommentEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.services.CommentService;
import lb.cnam.c2.v1.apis.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Comment", tags = {"Comment"})
@RequestMapping(path = "/v1/comment")
public final class CommentController {
	
	Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@CrossOrigin
	@ApiOperation(value="Add Comment", tags = {"Comment"})
	@RequestMapping(method = RequestMethod.PUT, path = "/")
	public ResponseEntity<Response> addComment (
			@RequestBody CommentEntity comment,
			@RequestParam(value = "jobId") int jobId,
			@RequestParam(value = "userId") int userId
		) {
		Response response = ResponseUtils.getSuccessResponse(commentService.addComment(jobId, userId, comment));
    	logger.debug("PUT: /v1/comment/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value="Delete Comment", tags = {"Comment"})
	@RequestMapping(method = RequestMethod.DELETE, path = "/")
	public ResponseEntity<Response> deleteComment (
			@RequestParam(value = "commentId") int commentId
		) {
		Response response = ResponseUtils.getSuccessResponse(commentService.deleteComment(commentId));
    	logger.debug("DELETE: /v1/comment/: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}