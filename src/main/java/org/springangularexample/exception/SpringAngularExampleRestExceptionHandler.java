/**
 * 
 */
package org.springangularexample.exception;

import org.springangularexample.dto.GenericResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author INST
 *
 */
@ControllerAdvice
public class SpringAngularExampleRestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * <p>
	 * Default Constructor
	 * </p>
	 */
	public SpringAngularExampleRestExceptionHandler() {
		super();
	}

	@Override
	@ExceptionHandler(value = Throwable.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		final GenericResponseDTO<String> message = new GenericResponseDTO<String>(null,
				"Server Error: An Internal Error occurred which prevented server from processing your request!");
		return super.handleExceptionInternal(ex, message, headers, HttpStatus.CONFLICT, request);
	}

}
