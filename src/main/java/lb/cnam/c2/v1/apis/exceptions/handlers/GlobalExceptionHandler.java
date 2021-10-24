package lb.cnam.c2.v1.apis.exceptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lb.cnam.c2.v1.apis.exceptions.global.MissingFieldException;
import lb.cnam.c2.v1.apis.exceptions.global.TypeParsingException;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.utils.handlers.ExceptionsHandlerUtils;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/** Base **/
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Response> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, illegalArgumentException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Response> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, httpMessageNotReadableException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Response> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, httpRequestMethodNotSupportedException, HttpStatus.BAD_REQUEST);
	}
	
	/** General **/
	
	@ExceptionHandler(MissingFieldException.class)
	public ResponseEntity<Response> handleMissingFieldException(MissingFieldException missingFieldException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, missingFieldException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TypeParsingException.class)
	public ResponseEntity<Response> handleTypeParsingException(TypeParsingException typeParsingException) {
		return ExceptionsHandlerUtils.handleExceptionResponse(logger, typeParsingException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}