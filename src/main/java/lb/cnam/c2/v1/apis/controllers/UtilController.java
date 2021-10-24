package lb.cnam.c2.v1.apis.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Util", tags = {"Util"})
@RequestMapping(path = "/v1/util")
public final class UtilController {

	Logger logger = LoggerFactory.getLogger(UtilController.class);
	
	@ApiOperation(value="Ping", tags = {"Util"})
	@RequestMapping(method = RequestMethod.GET, path = "/ping")
	public ResponseEntity<Response> ping(HttpServletRequest request, HttpEntity<String> httpEntity) {
		Response response = ResponseUtils.getSuccessResponse(true);
    	logger.debug("GET: /v1/util/ping: " + response);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
}