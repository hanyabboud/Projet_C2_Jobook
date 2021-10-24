package lb.cnam.c2.v1.apis.exceptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lb.cnam.c2.v1.apis.exceptions.custom.InvalidCommentException;
import lb.cnam.c2.v1.apis.exceptions.custom.InvalidJobException;
import lb.cnam.c2.v1.apis.exceptions.custom.InvalidUserException;
import lb.cnam.c2.v1.apis.exceptions.custom.TestException;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.utils.handlers.ExceptionsHandlerUtils;

@ControllerAdvice
public class CustomExceptionHandler {

	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(TestException.class)
	public ResponseEntity<Response> handleTestException(TestException testException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, testException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<Response> handleInvalidUserException(InvalidUserException invalidUserException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, invalidUserException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidJobException.class)
	public ResponseEntity<Response> handleInvalidJobException(InvalidJobException invalidJobException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, invalidJobException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCommentException.class)
	public ResponseEntity<Response> handleInvalidCommentException(InvalidCommentException invalidCommentException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, invalidCommentException, HttpStatus.NOT_FOUND);
	}
	
}