package lb.cnam.c2.v1.apis.utils.handlers;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.utils.ResponseUtils;

public class ExceptionsHandlerUtils {
	
	public static ResponseEntity<Response> handleExceptionResponse(Logger logger, Exception exception, HttpStatus httpStatus) {
		Response response = ResponseUtils.getErrorResponse(exception);
		logger.error(response.toString());
		return new ResponseEntity<Response>(response, httpStatus);
    }

}