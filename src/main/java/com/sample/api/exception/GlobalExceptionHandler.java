package com.sample.api.exception;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception Handler
 * @author vleon
 *
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    LOG.error(ex.getMessage());
    ExceptionResponse responseService = new ExceptionResponse(ex.getMessage(),
        request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(responseService, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex,
      WebRequest request) {
    LOG.error(ex.getMessage());
    ExceptionResponse responseService =
        new ExceptionResponse(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(responseService, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BusinessServiceException.class)
  public final ResponseEntity<Object> handleBusinessServiceException(HttpServletRequest req,
      BusinessServiceException ex) {
    ExceptionResponse responseService = new ExceptionResponse(ex.getMessage(), req.getRequestURI());
    return new ResponseEntity<>(responseService, HttpStatus.BAD_REQUEST);
  }

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder errorSB = new StringBuilder();
		for (FieldError error : ex.getBindingResult().getFieldErrors())
			errorSB.append("["+error.getField() + ": " + error.getDefaultMessage() + "] ");

		ExceptionResponse responseService = new ExceptionResponse(errorSB.toString(), request.getDescription(false),
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(responseService, HttpStatus.BAD_REQUEST);
	}
}
