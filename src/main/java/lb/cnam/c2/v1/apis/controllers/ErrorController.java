package lb.cnam.c2.v1.apis.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.utils.Error;

@RestController
public final class ErrorController {
	
	@RequestMapping(method = RequestMethod.POST, path = "/error")
	public Response postError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/error")
	public Response getError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.HEAD, path = "/error")
	public Response headError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/error")
	public Response putError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/error")
	public Response deleteError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS, path = "/error")
	public Response optionsError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
	@RequestMapping(method = RequestMethod.PATCH, path = "/error")
	public Response patchError() {
		return new Response(false, Error.INVALID_PATH, "");
	}
	
}