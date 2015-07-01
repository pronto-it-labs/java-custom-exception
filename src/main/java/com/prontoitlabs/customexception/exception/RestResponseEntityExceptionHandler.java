package com.prontoitlabs.customexception.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.ImmutableList;
import com.prontoitlabs.customexception.constant.Constants;
import com.prontoitlabs.customexception.util.RestResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * @author Giridhar
   *
   **/
  private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<RestResponse> handleUnknownException(Exception ex, WebRequest request) {
    LOGGER.error(ex.getMessage(), ex);

    return new ResponseEntity<RestResponse>(new RestResponse(Boolean.FALSE,
        ImmutableList.of(Constants.DEFAULT_ERROR_MESSAGE), null), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {UserNotFoundException.class})
  protected ResponseEntity<RestResponse> handleUserNotFound(UserNotFoundException ex, WebRequest request) {
      LOGGER.info("================="+ex+"WebRequest========"+request);
    return handleException(ex.getMessage(), HttpStatus.FORBIDDEN);
  }

  private ResponseEntity<RestResponse> handleException(String message, HttpStatus status) {
    LOGGER.error(message);
    return new ResponseEntity<RestResponse>(new RestResponse(Boolean.FALSE, ImmutableList.of(message), null), status);
  }
}
